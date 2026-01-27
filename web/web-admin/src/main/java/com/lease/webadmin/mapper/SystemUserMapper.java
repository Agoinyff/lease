package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lease.model.entity.SystemUser;
import com.lease.webadmin.vo.system.user.SystemUserItemVo;
import com.lease.webadmin.vo.system.user.SystemUserQueryVo;

/**
* @author yff
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
* @createDate 2026-01-22 10:02:44
* @Entity com.lease.model.entity.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    IPage<SystemUserItemVo> pageSystemUserItemVo(IPage<SystemUser> systemUserItemVoPage, SystemUserQueryVo queryVo);
}




