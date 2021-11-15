package org.tf.web.backend.dto;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;

/**
 * 用户登录成功状态标识
 * @author tuzi
 * @date 2021年11月14日 16:52
 */

public class LoginLzySuccess {
    @NotNull
    private  Integer id;
    @Value(value = "Unregistered")
    private String username;
    @Value("this is token, but I don't know how to write")
    private String token;
    @Value("false")
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "LoginLzySuccess{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
