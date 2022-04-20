package org.tf.web.backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tf.web.backend.dto.BucketCallbackDTO;
import org.tf.web.backend.service.BucketService;

import java.io.UnsupportedEncodingException;

/**
 * @author tuzi
 * @date 2022年03月22日 11:38
 */
@RestController
public class BucketController {
    @Autowired
    BucketService bucketService;

    @PostMapping("/bucket/update")
    public String generateUpdateToken(@RequestBody String data) {
        JSONObject jsonObject = JSON.parseObject(data);
        String token = bucketService.getUpdateToken(jsonObject.getString("key"));
        JSONObject response = new JSONObject();
        // 不确定获取失败是否为空
        if (token == null) {
            response.put("code", 400);
            response.put("message", "image update token get failed");
            JSONObject fail = new JSONObject();
            fail.put("fail", null);
            response.put("data", new JSONObject[]{fail});
        } else {
            response.put("code", 200);
            response.put("message", "image update token");
            JSONObject success = new JSONObject();
            success.put("updateToken", token);
            response.put("data", new JSONObject[]{success});
        }

        return response.toJSONString();
    }

    @PostMapping("/bucket/download")
    public String getImageUrl(@RequestBody String data) throws UnsupportedEncodingException {
        JSONObject jsonObject = JSON.parseObject(data);
        String imageUrl = bucketService.getFileUrl(jsonObject.getString("key"));
        JSONObject response = new JSONObject();
        // 不确定获取失败是否为空
        if (imageUrl == null) {
            response.put("code", 400);
            response.put("message", "image update token get failed");
            JSONObject fail = new JSONObject();
            fail.put("fail", null);
            response.put("data", new JSONObject[]{fail});
        } else {
            response.put("code", 200);
            response.put("message", "return image download URL");
            JSONObject success = new JSONObject();
            success.put("imageUrl", imageUrl);
            response.put("data", new JSONObject[]{success});
        }

        return response.toJSONString();
    }

    @GetMapping("/bucket/callbackUpdateImage")
    public void handleCallbackData(@RequestBody String data) {
        JSONObject jsonObject = JSON.parseObject(data);
        BucketCallbackDTO callback = new BucketCallbackDTO();
        callback.setHash(jsonObject.getString("hash"));
        callback.setKey(jsonObject.getString("key"));
        callback.setFsize(jsonObject.getString("fSize"));
        callback.setName(jsonObject.getString("name"));
        bucketService.handleCallback(callback);
        System.out.println(jsonObject);
        System.out.println("get callback");
    }
}
