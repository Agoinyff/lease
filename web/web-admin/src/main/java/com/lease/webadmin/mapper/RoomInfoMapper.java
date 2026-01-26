package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lease.model.entity.RoomInfo;
import com.lease.webadmin.vo.room.RoomItemVo;
import com.lease.webadmin.vo.room.RoomQueryVo;

/**
* @author yff
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
* @createDate 2026-01-22 10:02:44
* @Entity com.lease.model.entity.RoomInfo
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> pageItem(Page<RoomItemVo> roomItemVoPage, RoomQueryVo queryVo);
}




