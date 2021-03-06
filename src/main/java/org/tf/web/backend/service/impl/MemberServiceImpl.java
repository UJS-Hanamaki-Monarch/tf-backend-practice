package org.tf.web.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tf.web.backend.dao.MemberRepository;
import org.tf.web.backend.dto.MemberInfo;
import org.tf.web.backend.dto.MemberInfoData;
import org.tf.web.backend.pojo.User;
import org.tf.web.backend.service.MemberService;

import java.util.ArrayList;
import java.util.List;


/**
 * @author tuzi
 * @date 2022年01月26日 18:10
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberInfo ListMemberInfo() {
        MemberInfo memberInfo = new MemberInfo();
        MemberInfoData infoData = new MemberInfoData();
        List<MemberInfoData> dataList = new ArrayList<>();

        for (User user : memberRepository.findAllMemberInfo()) {
            infoData.setUsername(user.getUsername());
            infoData.setGrade(user.getGrade());
            infoData.setIcon(user.getIcon());
            infoData.setMotto(user.getMotto());
            dataList.add(infoData);
        }

        memberInfo.setCode(200);
        memberInfo.setMessage("get member info success");
        memberInfo.setData(dataList);

        return memberInfo;
    }
}
