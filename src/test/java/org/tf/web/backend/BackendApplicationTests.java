package org.tf.web.backend;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.tf.web.backend.entity.User;
import org.tf.web.backend.service.impl.HelloServiceimpl;
import org.tf.web.backend.utils.ScurityUtil;




@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("cxx");
        user.setPsw(ScurityUtil.encodePassword("123"));
        System.out.println(user.getPsw());


    }

}
