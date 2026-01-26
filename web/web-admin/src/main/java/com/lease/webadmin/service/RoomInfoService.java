package com.lease.webadmin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lease.model.entity.RoomInfo;
import com.lease.webadmin.vo.room.RoomDetailVo;
import com.lease.webadmin.vo.room.RoomItemVo;
import com.lease.webadmin.vo.room.RoomQueryVo;
import com.lease.webadmin.vo.room.RoomSubmitVo;

/**
* @author yff
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2026-01-22 10:02:44
*/
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageItem(Page<RoomItemVo> roomItemVoPage, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);

    void removeRoomById(Long id);
}
