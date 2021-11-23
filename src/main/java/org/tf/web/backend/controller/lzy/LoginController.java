package org.tf.web.backend.controller.lzy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.tf.web.backend.controller.UserLogin;
import org.tf.web.backend.dto.lzy.LoginSuccess;
import org.tf.web.backend.dto.lzy.UserAuth;
import org.tf.web.backend.dto.lzy.UserRepository;
import org.tf.web.backend.vo.LoginVo;

import java.util.Arrays;
import java.util.List;

@RestController
public class LoginController {
    // 用来测试 /login
    String phoneNumber = "12345678900";
    String psw = "123456";

    @Autowired // 自动装填
    private UserRepository userRepositorys;

    // 在service注入（后面在把代码封装到service层)
    @Autowired
    private BCryptPasswordEncoder encoder;

//    private static final Logger log = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping("/login")
    public UserLogin loginCheck(@RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
                                @RequestParam(value = "psw", defaultValue = "") String psw){
        boolean ifSuccess ;
        if (phoneNumber.equals(this.phoneNumber) && psw.equals(this.psw)){
            ifSuccess = true;
        }else {
            ifSuccess = false;
        }
        return new UserLogin(phoneNumber, ifSuccess);
    }

    @GetMapping("/lzy/login_mysql")
    public LoginSuccess loginMySQLCheck(@RequestParam String phoneNumber, @RequestParam String password) {
        UserAuth userAuth = new UserAuth();
        LoginSuccess loginSuccess = new LoginSuccess();

        userAuth.setPhoneNumber(phoneNumber);
        userAuth.setPassword(password);

        Integer uuid = userRepositorys.findUserForLogin(phoneNumber);
        loginSuccess.setUuid(uuid);
        loginSuccess.setState("success");
        // 这里需要改写为jwt生成token
        loginSuccess.setToken("ababa");
        return loginSuccess;
    }

    @PostMapping("/lzy/login")
    public LoginSuccess loginCheck(@RequestBody LoginVo loginVo) {
        LoginSuccess loginSuccess = new LoginSuccess();

        // 检查数据
        if (loginVo.getPhoneNumber() != null && loginVo.getPassword() != null) {
            Integer uuid = null;
            String dbPassword = userRepositorys.queryPassword(loginVo.getPhoneNumber());
            if (BCrypt.checkpw(loginVo.getPassword(), dbPassword)) {
                uuid = userRepositorys.findUserForLogin(loginVo.getPhoneNumber());
                // 登陆成功,获取token（这里先不封装）
                String token = "";
                token = JWT.create()
                        .withAudience(String.valueOf(uuid))
                        .sign(Algorithm.HMAC256(dbPassword));

                loginSuccess.setState("success");
                loginSuccess.setUuid(uuid);
                loginSuccess.setToken(token);
            }
        }

        return loginSuccess;
    }

    @GetMapping(path="lzy/test")
    public  Iterable<UserAuth> getAllUsers() {
        // This returns a JSON or XML with the users
//        return userRepositorys.findAll();
        return userRepositorys.queryByPhoneNumber("12345678900");
    }

    /**
     * 注册账号：摆设状态，用来测试 Bcrupt
     * @param loginVo
     * @return
     */
    @PostMapping(path = "/lzy/register")
    public String add(@RequestBody LoginVo loginVo) {
        // 加密密码
        return encoder.encode(loginVo.getPassword());
    }

    /**
     * 需要写一个拦截器去获取token并验证token;
     * 这里偷懒，不写全局的了
     * @param token
     * @return
     */
    @PostMapping("/lzy/check_token")
    public String TestCheckToken(@RequestBody String token) {
        // 权限验证略
        // 执行认证
        if (token == null) {
            return "跳转登录";
        }
        // 获取token中的uuid
        String uuid = JWT.decode(token).getAudience().get(0);

        List<String> userAuth = Arrays.asList(userRepositorys.queryByUuid(Integer.parseInt(uuid)).split(","));

        if (userAuth == null) {
            return "用户不存在";
        }
        // 验证token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(userAuth.get(2))).build();
        try {
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
