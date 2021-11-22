package org.tf.web.backend.dto;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    private String token;

    @NotNull
    private String username;
    @NotNull
    private String password;
}
