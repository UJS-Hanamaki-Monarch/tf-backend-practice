package org.tf.web.backend.controller;

public class UserLogin {

    private String userName ;
    private boolean ifLoginSuccess ;

    public UserLogin(String userName, boolean ifLoginSuccess){
        setUserName(userName);
        setIfLoginSuccess(ifLoginSuccess);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean getIfLoginSuccess() {
        return ifLoginSuccess;
    }

    public void setIfLoginSuccess(Boolean ifLoginSuccess) {
        this.ifLoginSuccess = ifLoginSuccess;
    }
}
