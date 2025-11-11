package com.blues.iamservice.service;

import io.minio.MinioClient;
import org.springframework.stereotype.Component;

@Component("fileRestClientApp")
public class FileRestClient extends com.blues.common.env.helper.FileRestClient {
    public FileRestClient(MinioClient minioClient) {
        super(minioClient);
    }
}