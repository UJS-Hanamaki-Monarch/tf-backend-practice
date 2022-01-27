package org.tf.web.backend.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 用户登录表
 * 
 * @author tuzi
 * @date 2021年11月20日 22:28
 */
@Entity(name = "user_auth")
@Data
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
    
    @Column(name = "username")
    private String username;
}
