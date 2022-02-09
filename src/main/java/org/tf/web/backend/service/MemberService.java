package org.tf.web.backend.service;

import org.tf.web.backend.dto.MemberInfo;

/**
 * @author tuzi
 * @date 2022年01月26日 17:33
 */

public interface MemberService {
    // 获取成员信息列表
    MemberInfo ListMemberInfo();
}
