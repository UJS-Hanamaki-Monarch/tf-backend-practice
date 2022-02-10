package org.tf.web.backend.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.tf.web.backend.dao.UserRepository;
import org.tf.web.backend.dto.LoginDTO;
import org.tf.web.backend.dto.LoginSuccessDTO;
import org.tf.web.backend.pojo.User;
import org.tf.web.backend.service.LoginService;

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

        return loginSuccess;
    }
}
