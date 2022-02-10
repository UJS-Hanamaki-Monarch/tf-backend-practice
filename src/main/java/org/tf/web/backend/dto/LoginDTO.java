package org.tf.web.backend.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {
    @Id
    private String id;
    @NotNull
    private String loginAccount;
    @NotNull
    private String loginPassword;
}
