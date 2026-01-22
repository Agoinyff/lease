package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.SystemPost;
import com.lease.webadmin.mapper.SystemPostMapper;
import com.lease.webadmin.service.SystemPostService;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【system_post(岗位信息表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService {

}




