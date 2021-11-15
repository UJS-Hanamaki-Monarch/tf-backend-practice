package org.tf.web.backend.dto;





import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author tuzi
 * @date 2021年11月14日 16:45
 */
@Entity(name = "user_lzy")
public class UserLzy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Column
    private String username;
    @NotNull
    @Column
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
