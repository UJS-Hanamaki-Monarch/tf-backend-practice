package org.tf.web.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.tf.web.backend.controller.LoginController;
import org.tf.web.backend.dao.UserRepository;
import org.tf.web.backend.dto.LoginSuccessDTO;
import org.tf.web.backend.pojo.User;
import org.tf.web.backend.vo.LoginVo;

@SpringBootTest
public class PortalServicesTests {

   @Autowired
   private LoginController loginController;

   @MockBean
   private UserRepository userRepository;

   @Test
	public void contextLoads() throws Exception {
		assertTrue(loginController != null);
	}

    @Test
    public void LoginServiceSuccessTest() {
        
        User mockUser = new User();
        mockUser.setAccount("123456");
        mockUser.setPassword("testPassword");
        when(userRepository.findUserByAccount("testUser")).thenReturn(mockUser);

        String testUsername = "testUser";
        String testPassword = "testPassword";
        LoginSuccessDTO loginInfo = loginController.loginCheck(new LoginVo(testUsername,testPassword));
        assertEquals("123456", loginInfo.getLoginAccount());
        assertEquals("success", loginInfo.getState());
    }
}
