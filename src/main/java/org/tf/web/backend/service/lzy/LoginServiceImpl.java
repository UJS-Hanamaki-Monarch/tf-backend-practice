package org.tf.web.backend.service.lzy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.tf.web.backend.dao.lzy.UserRepository;
import org.tf.web.backend.dto.lzy.LoginSuccessDTO;

/**
 * @author tuzi
 * @date 2022年01月21日 16:17
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired // 自动装填
    private UserRepository userRepositorys;

    /**
     * 用户登录验证
     * 注：只考虑使用username和password登录
     * @param username 用户名
     * @param password 明文密码
     * @return 登录结果
     */
    @Override
    public LoginSuccessDTO login(String username, String password) {
        LoginSuccessDTO loginSuccess = new LoginSuccessDTO();

        // 登录失败
        if (username == null || password == null) {
            loginSuccess.setState("flase");
            return loginSuccess;
        }

        Integer uuid = null;
        String dbPassword = userRepositorys.queryPassword(username);
        if (BCrypt.checkpw(password, dbPassword)) {
            uuid = userRepositorys.findUserForLogin(username);
            // 登录成功，获取token
            String token = "";
            token = JWT.create().withAudience(String.valueOf(uuid))
                    .sign(Algorithm.HMAC256(dbPassword));

            loginSuccess.setState("success");
            loginSuccess.setUuid(uuid);
            loginSuccess.setToken(token);
        }

        return loginSuccess;
    }
}
