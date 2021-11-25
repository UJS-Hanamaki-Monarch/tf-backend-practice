package org.tf.web.backend.dto.lzy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 用户基础信息表
 * @author tuzi
 * @date 2021年11月14日 16:45
 */
@Entity(name = "user")
public class User {
    @Id
    private Integer id;
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uuid;
    @NotNull
    private String username;
    @NotNull
    private String phoneNumber;
    @NotNull
    private int createTime;
    @NotNull
    private  int updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
