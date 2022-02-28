package org.tf.web.backend.dto;

import java.util.List;

/**
 * @author tuzi
 * @date 2022年01月26日 17:21
 */

public class MemberInfo {
    private Number code;
    private String message;
    private List<MemberInfoData> data;

    public Number getCode() {
        return code;
    }

    public void setCode(Number code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MemberInfoData> getData() {
        return data;
    }

    public void setData(List<MemberInfoData> data) {
        this.data = data;
    }
}

