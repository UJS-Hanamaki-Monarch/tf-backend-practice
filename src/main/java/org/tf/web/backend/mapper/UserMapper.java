package org.tf.web.backend.mapper;

import org.apache.ibatis.annotations.Param;
import org.tf.web.backend.entity.Login;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM tf_backend_user WHERE name=#{usr, jdbcType=VARCHAR}")

    Login  findByUsername(@Param("usr") String username);
}
