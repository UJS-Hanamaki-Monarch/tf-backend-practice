package org.tf.web.backend.dto;

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
    private  String loginAccount;
    @Value("this is token")
    private String token;
    @Value("false")
    private String state;
}
