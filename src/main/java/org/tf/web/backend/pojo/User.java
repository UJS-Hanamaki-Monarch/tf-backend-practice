package org.tf.web.backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.id.UUIDHexGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
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
}
