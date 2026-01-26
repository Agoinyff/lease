package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lease.model.entity.GraphInfo;
import com.lease.model.enums.ItemType;
import com.lease.webadmin.vo.graph.GraphVo;

import java.util.List;

/**
* @author yff
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2026-01-22 10:02:44
* @Entity com.lease.model.entity.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {


    List<GraphVo> getGraphVoListByApartmentId(ItemType itemType, Long id);
}




