package com.lease.webadmin.custom.config;


import com.lease.webadmin.custom.converter.StringToBaseEnumConverterFactory;
import com.lease.webadmin.custom.converter.StringToItemTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yff
 * @date 2026-01-22 14:31:42
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

//    @Autowired
//    private StringToItemTypeConverter stringToItemTypeConverter;
    @Autowired
    private StringToBaseEnumConverterFactory stringToBaseEnumConverterFactory;

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(this.stringToItemTypeConverter);
        registry.addConverterFactory(stringToBaseEnumConverterFactory);
    }
}
