package org.tf.web.backend.service.impl;

import org.springframework.stereotype.Service;
import org.tf.web.backend.dto.lzy.LoginSuccessDTO;
import org.tf.web.backend.service.LoginService;

/**
 * @author tuzi
 * @date 2022年01月21日 16:17
 */
@Service
public class LoginServiceImpl implements LoginService {
    /**
     * 用户登录验证
     * 注：只考虑使用username和password登录
     * @param username 用户名
     * @param password 明文密码
     * @return 登录结果
     */
    @Override
    public LoginSuccessDTO login(String username, String password) {
        return null;
    }
}
