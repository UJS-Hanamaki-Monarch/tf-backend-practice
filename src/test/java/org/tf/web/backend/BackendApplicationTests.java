package org.tf.web.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.tf.web.backend.dto.lzy.JsonData;

import static org.tf.web.backend.utils.lzy.TestJSON.generateJsonData;

@SpringBootTest
class BackendApplicationTests {
    /**
     * 联系org.json.jsonObject的使用
     */
    @Test
    public void testOrgJSON() throws JsonProcessingException {
        JsonData jsonData = generateJsonData(200, "this is message");


        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();

        // JsonData to json
        String jsonStr = mapper.writeValueAsString(jsonData);
        System.out.println(jsonStr);
    }

    public static void main(String[] args) {

    }

}
