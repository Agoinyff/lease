package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.FeeKey;
import com.lease.webadmin.mapper.FeeKeyMapper;
import com.lease.webadmin.service.FeeKeyService;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService {

}




