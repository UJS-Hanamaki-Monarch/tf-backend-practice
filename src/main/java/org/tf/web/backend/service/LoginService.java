package org.tf.web.backend.service;

import org.tf.web.backend.dto.LoginSuccessDTO;

/**
 * 用户登录发服务端接口
 * 要不要合并到userService???
 * @author tuzi
 * @date 2021年11月21日 8:53
 */

public interface LoginService {
    // 登录
    LoginSuccessDTO login(String username, String password);
}
