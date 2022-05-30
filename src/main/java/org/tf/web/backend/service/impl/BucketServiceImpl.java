package org.tf.web.backend.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.*;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tf.web.backend.dao.BucketRepository;
import org.tf.web.backend.dto.BucketCallbackDTO;
import org.tf.web.backend.service.BucketService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author tuzi
 * @date 2022年03月22日 14:13
 */

@Service
public class BucketServiceImpl implements BucketService {
    String accessKey = "aJD800lYr4KX84cpDd4YOkDf9LpKGz50EY--WwdT";
    String secretKey = "jvlrvdWFkvwTRm6K2xnD0QEZH0Xhlq53AvYHNmuq";
    String bucket = "lmscfw";
//    String key = "file key";
    @Autowired
    BucketRepository bucketRepository;



    @Override
    public String getUpdateToken(String fileKey) {
        Auth auth = Auth.create(accessKey, secretKey);
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        putPolicy.put("callbackUrl", "http://your_image/bucket/callbackUpdateImage");
        putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        putPolicy.put("callbackBodyType", "application/json");
        long expireSeconds = 3600;

        String upToken = auth.uploadToken(bucket, fileKey, expireSeconds, putPolicy);
        System.out.println(upToken);
        return upToken;
    }

    @Override
    public String getFileUrl(String fileName) throws UnsupportedEncodingException {
//        String fileName = "公司/存储/qiniu.jpg";


        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间

        Configuration cfg = new Configuration(Region.region0());

        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            // 测试图片是否存在
            FileInfo fileInfo = bucketManager.stat(bucket, fileName);
            System.out.println(fileInfo.hash);
            System.out.println(fileInfo.fsize);
            System.out.println(fileInfo.key);
            System.out.println(fileInfo.mimeType);
            System.out.println(fileInfo.putTime);

            String domainOfBucket = "https://image.dominikyang.top";
            String encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
            String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
            return auth.privateDownloadUrl(publicUrl, expireInSeconds);
        } catch (QiniuException ex) {
            System.err.println(ex.response.toString());
            return null;
        }
    }

    @Override
    public void handleCallback(BucketCallbackDTO data) {
        bucketRepository.save(data);
    }

    @Override
    public void updateImage(String localFilePath) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "test.jpg";
        Auth auth = Auth.create(accessKey, secretKey);
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        putPolicy.put("callbackUrl", "http://your_url/bucket/callbackUpdateImage");
        putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        putPolicy.put("callbackBodyType", "application/json");
        String upToken = auth.uploadToken(bucket, key, 300, putPolicy);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
//            Response response = uploadManager.put("D://test.jpg", key, upToken);
            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
            System.out.println("success!");
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
}
