package com.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yff
 * @date 2026-01-22 09:15:07
 */
@Configuration
@MapperScan({"com.lease.webadmin.mapper", "com.lease.webapp.mapper"})
public class MybatisPlusConfiguration {

}
