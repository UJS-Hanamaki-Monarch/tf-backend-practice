package org.tf.web.backend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.tf.web.backend.dto.LoginDTO;
import org.tf.web.backend.pojo.User;

import javax.validation.constraints.NotNull;

public interface UserRepository extends CrudRepository<User, String> {
    User findUserByAccount(@Param("account") String account);
}
