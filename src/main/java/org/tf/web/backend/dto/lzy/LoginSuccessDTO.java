package org.tf.web.backend.dto.lzy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;

/**
 * 用户登录成功状态标识
 * @author tuzi
 * @date 2021年11月14日 16:52
 */
@Data
public class LoginSuccessDTO {
    @NotNull
    private  Integer uuid;
    @Value("this is token, but I don't know how to write")
    private String token;
    @Value("false")
    private String state;
}
