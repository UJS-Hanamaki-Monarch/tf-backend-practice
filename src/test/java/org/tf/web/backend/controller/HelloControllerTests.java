package org.tf.web.backend.controller;

import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/login", map, String.class);
        Assertions.assertThat(responseEntity.getBody()).asString().isEqualTo("success");
    }
}
