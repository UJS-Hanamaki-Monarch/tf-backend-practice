package org.tf.web.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.tf.web.backend.pojo.User;

public interface UserRepository extends CrudRepository<User, String> {
    User findUserByAccount(@Param("account") String account);
}
