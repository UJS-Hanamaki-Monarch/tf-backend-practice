package org.tf.web.backend.dto.lzy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author tuzi
 * @date 2021年12月05日 10:48
 */
@Data
public class JsonUser {
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Value("user")
    private String name;
    @Value("this is a string motto")
    private String motto;
}
