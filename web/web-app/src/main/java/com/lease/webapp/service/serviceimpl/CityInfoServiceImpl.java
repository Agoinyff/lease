package com.lease.webapp.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.CityInfo;
import com.lease.webapp.service.CityInfoService;
import com.lease.webapp.mapper.CityInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author liubo
* @description 针对表【city_info】的数据库操作Service实现
* @createDate 2023-07-26 11:12:39
*/
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
    implements CityInfoService{

}




