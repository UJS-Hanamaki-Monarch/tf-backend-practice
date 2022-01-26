package org.tf.web.backend.service;

import org.tf.web.backend.dto.lzy.LoginSuccessDTO;

/**
 * 用户登录发服务端接口
 * 要不要合并到userService???
 * @author tuzi
 * @date 2021年11月21日 8:53
 */

public interface LoginService {
    LoginSuccessDTO login(String username, String password);
}
