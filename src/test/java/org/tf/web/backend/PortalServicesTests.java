package org.tf.web.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.tf.web.backend.controller.LoginController;
import org.tf.web.backend.dao.BucketRepository;
import org.tf.web.backend.dao.UserRepository;
import org.tf.web.backend.dto.BucketCallbackDTO;
import org.tf.web.backend.dto.LoginSuccessDTO;
import org.tf.web.backend.pojo.User;
import org.tf.web.backend.service.BucketService;
import org.tf.web.backend.vo.LoginVo;

@SpringBootTest
public class PortalServicesTests {

   @Autowired
   private LoginController loginController;

   @Autowired
    private BCryptPasswordEncoder encoder;

   @MockBean
   private UserRepository userRepository;

    @Autowired
    BucketService service;

   @Test
	public void contextLoads() throws Exception {
		assertTrue(loginController != null);
	}

    @Test
    public void LoginServiceSuccessTest() {
        
        User mockUser = new User();
        mockUser.setAccount("testUser");
        mockUser.setPassword(encoder.encode("testPassword"));
        when(userRepository.findUserByAccount("testUser")).thenReturn(mockUser);

        String testUsername = "testUser";
        String testPassword = "testPassword";
        LoginSuccessDTO loginInfo = loginController.loginCheck(new LoginVo(testUsername,testPassword));
        assertEquals("testUser", loginInfo.getLoginAccount());
        assertEquals("success", loginInfo.getState());
    }

    @Autowired
    BucketRepository bucketRepository;
    @Autowired
    BucketService bucketService;
    @Test
    public void testUpdate() {
        BucketCallbackDTO dto = new BucketCallbackDTO();
        dto.setHash("test");
        dto.setKey("test");
        dto.setName("test");
        dto.setFsize("test");
        bucketService.handleCallback(dto);
    }
}
