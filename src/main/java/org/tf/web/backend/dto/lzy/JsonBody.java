package org.tf.web.backend.dto.lzy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @author tuzi
 * @date 2021年12月05日 10:54
 */
@Data
public class JsonBody {
    @Value("this is info test")
    private String info;
    private List<JsonUser> users;
}
