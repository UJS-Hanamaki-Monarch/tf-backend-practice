package org.tf.web.backend.dao;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.tf.web.backend.dto.MemberInfoData;

import java.util.List;

public interface MemberRepository extends CrudRepository<MemberInfoData, Integer> {
    @Query("select m from member m")
    List<MemberInfoData> findAllMemberInfo();

    MemberInfoData findByNickName(@Param("nickName") String nickName);
}
