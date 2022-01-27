package org.tf.web.backend.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author tuzi
 * @date 2022年01月26日 17:40
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "member")
public class MemberInfoData {
    @NotNull
    @Id
    private String id;
    @NotNull
    @Column(name = "nick_name")
    private String nickName;
    @NotNull
    private Integer grade;
    @NotNull
    @Value("不悔梦归处，只恨太匆忙")
    private String brief;
    @NotNull
    private String icon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MemberInfoData that = (MemberInfoData) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
