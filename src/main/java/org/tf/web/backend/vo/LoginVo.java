package org.tf.web.backend.vo;

import lombok.Data;

/**
 * vo：视图层对象
 * view object 视图对象，用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来
 *
 * login界面数据
 * @author tuzi
 * @date 2021年11月21日 8:58
 */

@Data
public class LoginVo {
    private String username;
    private String password;
}
