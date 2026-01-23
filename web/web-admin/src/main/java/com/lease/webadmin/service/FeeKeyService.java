package com.lease.webadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lease.model.entity.FeeKey;
import com.lease.webadmin.vo.fee.FeeKeyVo;

import java.util.List;

/**
* @author yff
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service
* @createDate 2026-01-22 10:02:44
*/
public interface FeeKeyService extends IService<FeeKey> {

    List<FeeKeyVo> feeInfoList();
}
