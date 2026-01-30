package com.lease.webapp.controller.room;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lease.common.result.Result;
import com.lease.model.entity.RoomInfo;
import com.lease.webapp.service.RoomInfoService;
import com.lease.webapp.vo.room.RoomDetailVo;
import com.lease.webapp.vo.room.RoomItemVo;
import com.lease.webapp.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "房间信息")
@RestController
@RequestMapping("/app/room")
public class RoomController {

    @Autowired
    private RoomInfoService roomInfoService;

    @Operation(summary = "分页查询房间列表")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current, @RequestParam long size, RoomQueryVo queryVo) {

        Page<RoomItemVo> roomItemVoPage = new Page<>(current, size);

        IPage<RoomItemVo> page = roomInfoService.pageItemVo(roomItemVoPage, queryVo);


        return Result.ok(page);
    }

    @Operation(summary = "根据id获取房间的详细信息")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {


        return Result.ok(roomInfoService.getDetailById(id));
    }

    @Operation(summary = "根据公寓id分页查询房间列表")
    @GetMapping("pageItemByApartmentId")
    public Result<IPage<RoomItemVo>> pageItemByApartmentId(@RequestParam long current, @RequestParam long size, @RequestParam Long id) {

        Page<RoomItemVo> roomItemVoPage = new Page<>(current, size);
        IPage<RoomItemVo> result = roomInfoService.pageItemByApartmentId(roomItemVoPage, id);


        return Result.ok(result);
    }
}
