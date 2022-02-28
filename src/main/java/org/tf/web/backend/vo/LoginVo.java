package org.tf.web.backend.vo;


/**
 * vo：视图层对象
 * view object 视图对象，用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来
 *
 * login界面数据
 * @author tuzi
 * @date 2021年11月21日 8:58
 */

public class LoginVo {
    private String loginAccount;
    private String loginPassword;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public LoginVo() {
    }

    public LoginVo(String loginAccount, String loginPassword) {
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
    }
}
