package org.tf.web.backend.dto;


import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class LoginDTO {
    @Id
    private String id;
    @NotNull
    private String loginAccount;
    @NotNull
    private String loginPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
