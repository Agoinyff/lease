package com.lease.webapp.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.ApartmentLabel;
import com.lease.webapp.service.ApartmentLabelService;
import com.lease.webapp.mapper.ApartmentLabelMapper;
import org.springframework.stereotype.Service;

/**
* @author liubo
* @description 针对表【apartment_label(公寓标签关联表)】的数据库操作Service实现
* @createDate 2023-07-26 11:12:39
*/
@Service
public class ApartmentLabelServiceImpl extends ServiceImpl<ApartmentLabelMapper, ApartmentLabel>
    implements ApartmentLabelService{
}
