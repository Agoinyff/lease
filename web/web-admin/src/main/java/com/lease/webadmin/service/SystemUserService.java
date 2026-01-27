package com.lease.webadmin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lease.model.entity.SystemUser;
import com.lease.webadmin.vo.system.user.SystemUserItemVo;
import com.lease.webadmin.vo.system.user.SystemUserQueryVo;

/**
* @author yff
* @description 针对表【system_user(员工信息表)】的数据库操作Service
* @createDate 2026-01-22 10:02:44
*/
public interface SystemUserService extends IService<SystemUser> {

    IPage<SystemUserItemVo> pageSystemUserItemVo(IPage<SystemUser> systemUserItemVoPage, SystemUserQueryVo queryVo);
}
