package org.tf.web.backend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.tf.web.backend.pojo.User;

public interface MemberRepository extends CrudRepository<User, Integer> {
    @Query("select u from user u")
    Iterable<User> findAllMemberInfo();
}
