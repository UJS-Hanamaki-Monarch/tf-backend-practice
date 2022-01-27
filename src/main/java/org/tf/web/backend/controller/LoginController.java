package org.tf.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.tf.web.backend.dto.lzy.LoginSuccessDTO;
import org.tf.web.backend.service.LoginService;
import org.tf.web.backend.vo.LoginVo;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    // 在service注入（后面在把注册封装到service层后既可以删除了)
    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/login")
    public LoginSuccessDTO loginCheck(@RequestBody LoginVo loginVo) {
        String username = loginVo.getUsername();
        String passowrd = loginVo.getPassword();

        LoginSuccessDTO loginSuccess = new LoginSuccessDTO();

        loginSuccess = loginService.login(username, passowrd);

        return loginSuccess;
    }

    /**
     * 注册账号：摆设状态，用来偷懒获取加密密码
     * (没有封装到Service里面)
     * @param loginVo
     * @return
     */
    @PostMapping(path = "/register")
    public String add(@RequestBody LoginVo loginVo) {
        // 加密密码
        return encoder.encode(loginVo.getPassword());
    }
}
