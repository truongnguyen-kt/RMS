package com.blues.iamservice.config.minio;


import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MinioConfig.class)
public class MinioClientConfig {
    private final MinioConfig minioConfig;

    @Bean
    public MinioClient minioClient()
            throws ServerException, InsufficientDataException, ErrorResponseException, IOException,
            NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException,
            InternalException {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(minioConfig.getEndpoint())
                .credentials(
                        minioConfig.getAccessKey(),
                        minioConfig.getSecretKey()
                )
                .build();

        String bucketName = minioConfig.getBucketName();
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        } else {
            log.info("Bucket with name: {} has already exits", bucketName);
        }
        return minioClient;
    }
}