package org.tf.web.backend.controller;

/**
 * @author tuzi
 * @date 2021年11月03日 11:38
 */

public class Tuzi01Loin {
    private String user;
    private String password;

    public Tuzi01Loin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Tuzi01Loin{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
