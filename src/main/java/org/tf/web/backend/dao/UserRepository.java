package org.tf.web.backend.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.tf.web.backend.entity.UserAuth;

public interface UserRepository extends CrudRepository<UserAuth, Integer> {
//    @Query("select uuid from user_auth where username=?1 and password=?2 ")
//    @Query("select user.uuid from UserAuth user where user.username=:username and user.password=:password ")
    @Query("select uuid from user_auth where username=:username")
    Integer findUserForLogin(@Param("username") String username);

    /**
     * 改成获取user_auth的对象最佳
     * @param username
     * @return
     */
    @Query(value = "select password from user_auth where username=:username")
    String queryPassword(String username);
}
