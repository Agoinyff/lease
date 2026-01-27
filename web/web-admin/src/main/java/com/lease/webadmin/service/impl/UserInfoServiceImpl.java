package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.UserInfo;
import com.lease.webadmin.mapper.UserInfoMapper;
import com.lease.webadmin.service.UserInfoService;
import com.lease.webadmin.vo.user.UserInfoQueryVo;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class  UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {


}




