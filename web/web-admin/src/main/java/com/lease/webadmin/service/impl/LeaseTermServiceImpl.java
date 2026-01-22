package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.LeaseTerm;
import com.lease.webadmin.mapper.LeaseTermMapper;
import com.lease.webadmin.service.LeaseTermService;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【lease_term(租期)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
    implements LeaseTermService {

}




