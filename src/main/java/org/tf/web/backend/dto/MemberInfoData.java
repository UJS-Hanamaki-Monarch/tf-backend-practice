package org.tf.web.backend.dto;

import org.springframework.beans.factory.annotation.Value;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author tuzi
 * @date 2022年01月26日 17:40
 */

public class MemberInfoData {
    @NotNull
    @Column(name = "username")
    private String username;
    @NotNull
    private Integer grade;
    @NotNull
    @Value("不悔梦归处，只恨太匆忙")
    private String motto;
    @NotNull
    private String icon;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
