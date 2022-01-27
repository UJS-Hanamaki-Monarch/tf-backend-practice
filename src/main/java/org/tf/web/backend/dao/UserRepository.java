package org.tf.web.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.tf.web.backend.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
}
