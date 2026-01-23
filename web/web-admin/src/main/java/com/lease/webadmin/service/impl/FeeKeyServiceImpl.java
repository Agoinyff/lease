package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.FeeKey;
import com.lease.webadmin.mapper.FeeKeyMapper;
import com.lease.webadmin.service.FeeKeyService;
import com.lease.webadmin.vo.fee.FeeKeyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yff
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService {

    @Autowired
    private FeeKeyMapper feeKeyMapper;

    @Override
    public List<FeeKeyVo> feeInfoList() {

       return feeKeyMapper.feeInfoList();

    }
}




