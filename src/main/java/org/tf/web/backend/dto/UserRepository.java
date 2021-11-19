package org.tf.web.backend.dto;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserLzy, Integer> {
//    @Query("select id from User where username=?1 and password=?2 ")
//    @Query("select user.id from User user where user.username=:username and user.password=:password ")
    @Query("select id from user_lzy where username=:username and password=:password ")
    Integer findUserLzyForLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "select username from user_lzy where password= :password")
    String queryByPassword(String password);
}
