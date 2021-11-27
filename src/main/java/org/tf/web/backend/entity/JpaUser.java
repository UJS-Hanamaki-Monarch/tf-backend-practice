package org.tf.web.backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "jpa_user")
@Data
public class JpaUser {
    @Id
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
}
