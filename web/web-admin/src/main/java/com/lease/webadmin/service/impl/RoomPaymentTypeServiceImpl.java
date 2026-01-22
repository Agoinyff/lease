package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.RoomPaymentType;
import com.lease.webadmin.mapper.RoomPaymentTypeMapper;
import com.lease.webadmin.service.RoomPaymentTypeService;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【room_payment_type(房间&支付方式关联表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class RoomPaymentTypeServiceImpl extends ServiceImpl<RoomPaymentTypeMapper, RoomPaymentType>
    implements RoomPaymentTypeService {

}




