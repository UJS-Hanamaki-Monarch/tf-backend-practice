package org.tf.web.backend.dto.lzy;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;

/**
 * 用户登录成功状态标识
 * @author tuzi
 * @date 2021年11月14日 16:52
 */

public class LoginSuccess {
    @NotNull
    private  Integer uuid;
    @Value("this is token, but I don't know how to write")
    private String token;
    @Value("false")
    private String state;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
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
        return "LoginSuccess{" +
                "uuid=" + uuid +
                ", token='" + token + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
