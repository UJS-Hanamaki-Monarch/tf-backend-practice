package org.tf.web.backend.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loginSuccessTest(){

        Map<String,String> map= new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/hello/login", map, String.class);
        Assertions.assertThat(responseEntity.getBody()).asString().isEqualTo("success");
    }
}
