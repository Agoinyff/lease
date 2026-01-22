package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.LeaseAgreement;
import com.lease.webadmin.mapper.LeaseAgreementMapper;
import com.lease.webadmin.service.LeaseAgreementService;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
    implements LeaseAgreementService {

}




