package org.tf.web.backend.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.tf.web.backend.dao.UserRepository;
import org.tf.web.backend.dto.LoginSuccessDTO;
import org.tf.web.backend.pojo.User;
import org.tf.web.backend.service.LoginService;
import org.tf.web.backend.vo.AddUserVO;

/**
 * @author tuzi
 * @date 2022年01月21日 16:17
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepositorys;
    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * 用户登录验证
     * 注：只考虑使用username和password登录
     * @param loginAccount 用户名
     * @param loginPassword 明文密码
     * @return 登录结果
     */
    @Override
    public LoginSuccessDTO login(String loginAccount, String loginPassword) {
        LoginSuccessDTO loginSuccess = new LoginSuccessDTO();

        // 登录失败
        if (loginAccount == null || loginPassword == null) {
            loginSuccess.setState("false");
            return loginSuccess;
        }

        User loginDTO = userRepositorys.findUserByAccount(loginAccount);
        String id = null;
        String dbPassword = loginDTO.getPassword();
        if (BCrypt.checkpw(loginPassword, dbPassword)) {
            id = loginDTO.getId();
            // 登录成功，获取token
            String token = "";
            token = JWT.create().withAudience(String.valueOf(id))
                    .sign(Algorithm.HMAC256(dbPassword));

            loginSuccess.setState("success");
            loginSuccess.setLoginAccount(loginAccount);
            loginSuccess.setToken(token);
        }
        // TODO 失败返回

        return loginSuccess;
    }

    @Override
    public String addUser(AddUserVO user) {
        // TODO 代码优化，新增构造函数
        // TODO LoginAccount需要判断是否重复再进行插入
        User user1 = new User();
        user1.setAccount(user.getLoginAccount());
        user1.setGrade(user.getGrade());
        user1.setIcon(user.getIcon());
        user1.setUsername(user.getUsername());
        user1.setMotto(user.getMotto());
        user1.setPassword(encoder.encode(user.getLoginPassword()));
        userRepositorys.save(user1);
        return "success";
    }
}
