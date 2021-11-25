package org.tf.web.backend.dto.lzy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 用户登录表
 * @author tuzi
 * @date 2021年11月20日 22:28
 */
@Entity(name = "user_auth")
public class UserAuth {
    @Id
    @Column(name = "id")
    private int id;
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    private int uuid;
    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull
    private String password;
    @Column(name = "update_time")
    private int updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
