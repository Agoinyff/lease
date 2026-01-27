package com.lease.webapp.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.FeeKey;
import com.lease.webapp.service.FeeKeyService;
import com.lease.webapp.mapper.FeeKeyMapper;
import org.springframework.stereotype.Service;

/**
* @author liubo
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate 2023-07-26 11:12:39
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService{

}




