package com.lease.webadmin.custom.converter;


import com.lease.model.enums.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author yff
 * @date 2026-01-22 14:24:12
 */
@Component
public class StringToItemTypeConverter implements Converter<String, ItemType> {

    @Override
    public ItemType convert(String code) {

        ItemType[] values = ItemType.values();
        for (ItemType itemType : values) {
            if (itemType.getCode().equals(Integer.valueOf(code))) {
                return itemType;
            }
        }
        throw new IllegalArgumentException("code:" + code + "非法");

    }
}
