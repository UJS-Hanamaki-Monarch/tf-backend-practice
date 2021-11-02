package org.tf.web.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/{username}")
    public String hello(@PathVariable("username")String username){
        return "hello " + username + " !";
    }
}
