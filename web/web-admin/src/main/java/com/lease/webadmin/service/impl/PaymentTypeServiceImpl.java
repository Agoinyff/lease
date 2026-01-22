package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.PaymentType;
import com.lease.webadmin.mapper.PaymentTypeMapper;
import com.lease.webadmin.service.PaymentTypeService;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService {

}




