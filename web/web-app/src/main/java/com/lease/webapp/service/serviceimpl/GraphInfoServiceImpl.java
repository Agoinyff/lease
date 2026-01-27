package com.lease.webapp.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.GraphInfo;
import com.lease.webapp.service.GraphInfoService;
import com.lease.webapp.mapper.GraphInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author liubo
* @description 针对表【graph_info(图片信息表)】的数据库操作Service实现
* @createDate 2023-07-26 11:12:39
*/
@Service
public class GraphInfoServiceImpl extends ServiceImpl<GraphInfoMapper, GraphInfo>
    implements GraphInfoService{

}




