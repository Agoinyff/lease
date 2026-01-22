package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.ApartmentInfo;
import com.lease.webadmin.mapper.ApartmentInfoMapper;
import com.lease.webadmin.service.ApartmentInfoService;
import org.springframework.stereotype.Service;

/**
 * @author yff
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2026-01-22 10:02:43
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

}
