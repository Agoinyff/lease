package com.lease.webadmin.custom.converter;


import com.lease.model.enums.BaseEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * @author yff
 * @date 2026-01-22 14:43:15
 */
//一个通用的枚举转换器工厂
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            @Override
            public T convert(String code) {
                T[] enumConstants = targetType.getEnumConstants();
                for (T enumConstant : enumConstants) {
                    if (enumConstant.getCode().equals(Integer.valueOf(code))) {
                        return enumConstant;
                    }
                }
                throw new IllegalArgumentException("code:" + code + "非法");
            }
        };
    }
}
