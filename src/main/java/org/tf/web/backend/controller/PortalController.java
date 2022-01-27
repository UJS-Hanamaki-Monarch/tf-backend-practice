package org.tf.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tf.web.backend.dto.MemberInfo;
import org.tf.web.backend.service.MemberService;

/**
 * @author tuzi
 * @date 2022年01月26日 17:35
 */
@RestController
public class PortalController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/info")
    public MemberInfo listMemberInfo() {
        return memberService.ListMemberInfo();
    }
}
