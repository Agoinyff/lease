package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lease.model.entity.LeaseAgreement;
import com.lease.webadmin.vo.agreement.AgreementQueryVo;
import com.lease.webadmin.vo.agreement.AgreementVo;

/**
* @author yff
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2026-01-22 10:02:44
* @Entity com.lease.model.entity.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);
}




