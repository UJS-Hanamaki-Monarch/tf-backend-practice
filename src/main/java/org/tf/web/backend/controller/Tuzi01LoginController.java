package org.tf.web.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Objects;

/**
 * @author tuzi
 * @date 2021年11月03日 11:34
 */
@RestController
public class Tuzi01LoginController {
    @GetMapping("/tuzi/login-01")
    public Tuzi01Loin tuzi01Loin(@RequestParam(value = "user", defaultValue = "admin") String user, @RequestParam(value = "password") String password ) {
        return new Tuzi01Loin(user, password);
    }

    @GetMapping("/tuzi/login-02")
    public String tuzi01Loin02(@RequestParam(value = "user", defaultValue = "admin") String user, @RequestParam(value = "password") String password ) {
        if (user.equals("admin") && password.equals("123456")) {
            return "success";
        }
        return "false";
    }
    @GetMapping("/tuzi/login-03")
    public String tuzi01Loin03(@RequestParam(value = "user", defaultValue = "admin") String user, @RequestParam(value = "password") String password ) {
        if (user.equals("admin") && password.equals("123456")) {
            return "success";
        }
        return "false";
    }
}
