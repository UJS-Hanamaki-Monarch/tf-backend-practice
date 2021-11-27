package org.tf.web.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.tf.web.backend.entity.JpaUser;

public interface JpaUserRepository extends CrudRepository<JpaUser,Integer> {

    @Query(value = "select id from jpa_user where username = :username")
    Integer queryByUsername(String username);
}
