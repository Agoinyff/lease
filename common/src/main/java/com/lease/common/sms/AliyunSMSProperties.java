package com.lease.common.sms;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yff
 * @date 2026-01-27 16:14:33
 */
@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunSMSProperties {

    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;

}
