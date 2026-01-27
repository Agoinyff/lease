package com.lease.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yff
 * @date 2026-01-23 09:36:47
 */
@Configuration
@ConfigurationPropertiesScan("com.lease.common.minio")
@ConditionalOnProperty(prefix = "minio", name = "endpoint")
public class minioConfiguration {

    // @Value("${minio.endpoint}")
    // private String endpoint;
    // @Value("${minio.accessKey}")
    // private String accessKey;
    // @Value("${minio.secretKey}")
    // private String secretKey;
    @Autowired
    private MinioProperties minioProperties;

    // 创建并配置 MinioClient 实例的 Bean
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(minioProperties.getEndpoint())
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey()).build();
    }

}
