package com.lease.webapp.custom.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

/**
 * @author yff
 * @date 2026-01-27 15:01:09
 */
public class Knife4jConfiguration {

//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("APP接口")
//                        .version("1.0")
//                        .description("用户端APP接口")
//                        .termsOfService("http://doc.xiaominfo.com")
//                        .license(new License().name("Apache 2.0")
//                                .url("http://doc.xiaominfo.com")));
//    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("APP接口")
                        .version("1.0")
                        .description("用户端APP接口"));
    }



    @Bean
    public GroupedOpenApi loginAPI() {
        return GroupedOpenApi.builder().group("登录信息").
                pathsToMatch("/app/login/**", "/app/info").
                build();
    }

    @Bean
    public GroupedOpenApi personAPI() {
        return GroupedOpenApi.builder().group("个人信息").
                pathsToMatch(
                        "/app/history/**",
                        "/app/appointment/**",
                        "/app/agreement/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi lookForRoomAPI() {
        return GroupedOpenApi.builder().group("找房信息").
                pathsToMatch(
                        "/app/apartment/**",
                        "/app/room/**",
                        "/app/payment/**",
                        "/app/region/**",
                        "/app/term/**"
                ).
                build();
    }


}
