package org.tf.web.backend.service;


import org.tf.web.backend.dto.BucketCallbackDTO;

import java.io.UnsupportedEncodingException;

public interface BucketService {
    public String getUpdateToken(String fileKey);

    public String getFileUrl(String fileKay) throws UnsupportedEncodingException;

    public void handleCallback(BucketCallbackDTO data);

    /**
     *
     * @param localFilePath //如果是Windows情况下，格式是 D:\\qiniu\\test.png
     */
    void updateImage(String localFilePath);
}
