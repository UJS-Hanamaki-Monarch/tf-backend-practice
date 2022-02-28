package org.tf.web.backend.dto;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;

/**
 * 用户登录成功状态标识
 * @author tuzi
 * @date 2021年11月14日 16:52
 */
public class LoginSuccessDTO {
    
    @NotNull
    private  String loginAccount;

    @Value("this is token")
    private String token;

    @Value("false")
    private String state;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LoginSuccessDTO() {
    }

    public LoginSuccessDTO(String loginAccount, String token, String state) {
        this.loginAccount = loginAccount;
        this.token = token;
        this.state = state;
    }
}
