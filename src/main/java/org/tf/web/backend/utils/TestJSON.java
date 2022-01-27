package org.tf.web.backend.utils;

import org.tf.web.backend.dto.lzy.JsonBody;
import org.tf.web.backend.dto.lzy.JsonData;
import org.tf.web.backend.dto.lzy.JsonUser;

import java.util.ArrayList;
import java.util.List;

/**
 * JSONObject 与 Java之间的映射关系
 * @author tuzi
 * @date 2021年12月05日 9:54
 */

public class TestJSON {


    /**
     * 创建一个user, 偷懒版
     * @param id user-id
     * @return
     */
    public static JsonUser generateJsonUser(Integer id) {
        JsonUser jsonUser = new JsonUser();
        jsonUser.setId(id);
        jsonUser.setName("user" + jsonUser.getId().toString());
        jsonUser.setMotto("this is a string motto");
        return jsonUser;
    }

    /**
     * 创建一个user object
     * @param number 创建的user的数量
     * @param info info
     * @return
     */
    public static JsonBody generateJsonBody(int number, String info) {
        JsonBody body = new JsonBody();
        List<JsonUser> users = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            users.add(generateJsonUser(i));
        }

        body.setInfo(info);
        body.setUsers(users);
        return body;
    }

    public static JsonData generateJsonData(Integer code, String message) {
        JsonData jsonData = new JsonData();
        jsonData.setCode(code);
        jsonData.setMessage(message);
        jsonData.setBody(generateJsonBody(6, "this is a info test"));
        return jsonData;
    }
}
