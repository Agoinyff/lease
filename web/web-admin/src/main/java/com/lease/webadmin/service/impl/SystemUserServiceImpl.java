package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.SystemUser;
import com.lease.webadmin.mapper.SystemUserMapper;
import com.lease.webadmin.service.SystemUserService;
import com.lease.webadmin.vo.system.user.SystemUserItemVo;
import com.lease.webadmin.vo.system.user.SystemUserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【system_user(员工信息表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public IPage<SystemUserItemVo> pageSystemUserItemVo(IPage<SystemUser> systemUserItemVoPage, SystemUserQueryVo queryVo) {

      return systemUserMapper.pageSystemUserItemVo(systemUserItemVoPage,queryVo);


    }
}




