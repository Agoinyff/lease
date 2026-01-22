package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.SystemUser;
import com.lease.webadmin.mapper.SystemUserMapper;
import com.lease.webadmin.service.SystemUserService;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【system_user(员工信息表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService {

}




