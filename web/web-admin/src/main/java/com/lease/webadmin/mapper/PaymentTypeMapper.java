package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lease.model.entity.PaymentType;

import java.util.List;

/**
 * @author yff
 * @description 针对表【payment_type(支付方式表)】的数据库操作Mapper
 * @createDate 2026-01-22 10:02:44
 * @Entity com.lease.model.entity.PaymentType
 */
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    List<PaymentType> selectListByRoomId(Long roomId);
}
