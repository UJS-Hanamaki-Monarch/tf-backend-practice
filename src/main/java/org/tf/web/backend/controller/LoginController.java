package org.tf.web.backend.controller;

import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.tf.web.backend.dto.LoginDTO;
import org.tf.web.backend.entity.User;
import org.tf.web.backend.service.HelloService;
import org.tf.web.backend.utils.TokenUtils;

import javax.validation.Valid;

@RestController
public class LoginController {
//    String userName = "user1";
//    String psw = "123456";

    @Autowired
    private HelloService helloService;

    @Autowired
    public LoginController(HelloService helloService){
        this.helloService = helloService;
    }

    @PostMapping("login")
    public String login(@Valid @RequestBody LoginDTO loginDTO, BindingResult result){

        TokenUtils tokenUtils = new TokenUtils();

        if(result.hasErrors()){
            result.getAllErrors().forEach(objectError -> System.out.println(objectError.toString()));
            return "false";
        }
        if (loginDTO.getToken() != null){
            // 带了token
            String  nameInToken = tokenUtils.getUsername(loginDTO.getToken());
            if (nameInToken.equals(loginDTO.getUsername())){
                return "seccess";
            }else {
                return "fail: wrong token";
            }
        }
            // 没有携带token
        else if(helloService.checkUserInfo(loginDTO.getUsername(),loginDTO.getPassword())){
            String token = "";
            User user = helloService.getUserByName(loginDTO.getUsername());
            token = tokenUtils.getToken(user);
            return "sucess "+ token;
        }
        return "false";
    }

}
