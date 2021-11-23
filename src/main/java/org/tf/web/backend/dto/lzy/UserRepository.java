package org.tf.web.backend.dto.lzy;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.tf.web.backend.vo.LoginVo;

import java.util.List;

public interface UserRepository extends CrudRepository<UserAuth, Integer> {
//    @Query("select uuid from user_auth where phoneNumber=?1 and password=?2 ")
//    @Query("select user.uuid from UserAuth user where user.phoneNumber=:phoneNumber and user.password=:password ")
    @Query("select uuid from user_auth where phoneNumber=:phoneNumber")
    Integer findUserForLogin(@Param("phoneNumber") String phoneNumber);


    @Query(value = "select uuid, phoneNumber, password from user_auth where phoneNumber=:phoneNumber")
    Iterable<UserAuth> queryByPhoneNumber(String phoneNumber);

    @Query(value = "select uuid, phoneNumber, password from user_auth where uuid=:uuid")
    String queryByUuid(Integer uuid);


    /**
     * 改成获取user_auth的对象最佳
     * @param phoneNumber
     * @return
     */
    @Query(value = "select password from user_auth where phoneNumber=:phoneNumber")
    String queryPassword(String phoneNumber);
}
