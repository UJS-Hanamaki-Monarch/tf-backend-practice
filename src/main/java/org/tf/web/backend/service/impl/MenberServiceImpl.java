package org.tf.web.backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tf.web.backend.dao.MemberRepository;
import org.tf.web.backend.dto.MemberInfo;
import org.tf.web.backend.service.MemberService;


/**
 * @author tuzi
 * @date 2022年01月26日 18:10
 */
@Service
public class MenberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @SneakyThrows
    @Override
    public MemberInfo ListMemberInfo() {
        MemberInfo memberInfo = new MemberInfo();
        ObjectMapper mapper = new ObjectMapper();

        memberInfo.setCode(200);
        memberInfo.setMessage("get member info success");
        memberInfo.setData(memberRepository.findAllMemberInfo());


        return memberInfo;
    }
}
