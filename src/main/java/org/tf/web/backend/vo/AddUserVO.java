package org.tf.web.backend.vo;

import lombok.Data;

/**
 * @author tuzi
 * @date 2022年02月09日 14:51
 */
@Data
public class AddUserVO {
    private String username;
    private String loginAccount;
    private Integer grade;
    private String loginPassword;
    private String icon; // 前端上传到图片服务器
    private String motto;
}
