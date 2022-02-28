package org.tf.web.backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author tuzi
 * @date 2022年02月09日 12:52
 */
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "UUIDHexGenerator")
    @GenericGenerator(name="UUIDHexGenerator", strategy="uuid")
    @Column(length = 32)
    private String id;
    private String username;
    @Column(name = "login_account")
    private String account;
    private Integer grade;
    @Column(name = "login_password")
    private String password;
    private String icon;
    private String motto;
    @Column(name="create_time")
    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @Column(name="update_time")
    @UpdateTimestamp
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
