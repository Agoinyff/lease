package com.lease.webadmin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lease.model.entity.LeaseAgreement;
import com.lease.webadmin.vo.agreement.AgreementQueryVo;
import com.lease.webadmin.vo.agreement.AgreementVo;

/**
* @author yff
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2026-01-22 10:02:44
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);
}
