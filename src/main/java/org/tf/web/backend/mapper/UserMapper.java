package org.tf.web.backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.tf.web.backend.entity.Login;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.tf.web.backend.entity.User;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM tf_backend_user WHERE name=#{usr, jdbcType=VARCHAR}")
    User findByUsername(@Param("usr") String username);

    @Insert("INSERT INTO tf_backend_user (uuid,name,psw) VALUES (#{uuid}, #{name}, #{psw})")
    void insertUser(User user);
}
