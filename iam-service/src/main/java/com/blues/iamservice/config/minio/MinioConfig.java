package com.blues.iamservice.config.minio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "minio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MinioConfig {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private final SubPath subPath = new SubPath();
    private final AllowedExtension allowedExtension = new AllowedExtension();

    @Getter
    @Setter
    public static class SubPath {
        private String avatar;
    }

    @Getter
    @Setter
    public static class AllowedExtension {
        private String avatar;
    }
}
