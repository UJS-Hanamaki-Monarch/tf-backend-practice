package org.tf.web.backend.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author tuzi
 * @date 2022年01月26日 17:40
 */

@Data
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
}
