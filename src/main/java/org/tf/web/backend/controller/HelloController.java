package org.tf.web.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.tf.web.backend.dto.LoginDTO;
import org.tf.web.backend.entity.Product;
import org.tf.web.backend.repository.JpaUserRepository;
import org.tf.web.backend.repository.UserRepository;
import org.tf.web.backend.service.HelloService;
import org.tf.web.backend.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;
    private final ProductService productService;
    private final UserRepository userRepository;
    private final JpaUserRepository jpaUserRepository;
    @GetMapping("/hello/{username}")
    public String hello(@PathVariable("username")String username){
        return "hello " + username + " !";
    }

    @PostMapping("login")
    public String login(@Valid @RequestBody LoginDTO loginDTO, BindingResult result){
        if(result.hasErrors()){
            result.getAllErrors().forEach(objectError -> System.out.println(objectError.toString()));
            return "false";
        }
        if(Boolean.TRUE.equals(helloService.checkUserInfo(loginDTO.getUsername(),loginDTO.getPassword()))){
            return userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword()).get();
        }
        return "false";
    }

    @GetMapping("userId")
    public Integer userId(){
        return jpaUserRepository.queryByUsername("test");
    }

    @PostMapping("/elastic/product/create")
    public String createElasticProduct(){
        Product product = new Product(UUID.randomUUID().toString(),"Test Product", Product.Category.CLOTHES, 14.99);
        System.out.println(product);
        Product serviceProduct = productService.createProduct(product);
        System.out.println(serviceProduct);
        return "create success";
    }

    @GetMapping("/elastic/product/list")
    public List<Product> listElasticProduct(){
        return productService.findAll();
    }
}
