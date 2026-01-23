package com.lease.common.minio;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yff
 * @date 2026-01-23 10:45:56
 */
@Data
@ConfigurationProperties(prefix = "minio")   // 指定前缀将外部配置（application.properties / application.yml）中以 minio 为前缀的属性，
// 自动绑定到 MinioProperties 类的字段上，便于在代码中以强类型访问配置。
public class MinioProperties {

    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;


}
