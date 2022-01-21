package org.tf.web.backend.dto.lzy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 一个json-object映射
 * @author tuzi
 * @date 2021年12月05日 10:47
 */
@Data
public class JsonData {
    @Value("200")
    private Integer code;
    @Value(value = "this is amessage")
    private String message;
    private JsonBody body;
}
