package org.tf.web.backend.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.tf.web.backend.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
    @Query("select * from tf_backend_user where username = :username and password = :password")
    User getByUsernameAndPassword(String username, String password);

    @Query("select id from tf_backend_user where username = :username and password = :password")
    Optional<String> findByUsernameAndPassword(String username, String password);
}
