package org.tf.web.backend.pojo;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author tuzi
 * @date 2022年02月09日 12:52
 */
@Entity(name = "user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    @Column(name = "login_account")
    private String account;
    private Integer grade;
    @Column(name = "login_password")
    private String password;
    private String icon;
    private String motto;

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
}
