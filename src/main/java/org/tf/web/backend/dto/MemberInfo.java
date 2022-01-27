package org.tf.web.backend.dto;

import lombok.Data;
import java.util.List;

/**
 * @author tuzi
 * @date 2022年01月26日 17:21
 */
@Data
public class MemberInfo {
    private Number code;
    private String message;
    private List<MemberInfoData> data;
}

