package org.tf.web.backend.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
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

