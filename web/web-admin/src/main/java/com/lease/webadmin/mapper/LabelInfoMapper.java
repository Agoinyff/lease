package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lease.model.entity.LabelInfo;

import java.util.List;

/**
 * @author yff
 * @description 针对表【label_info(标签信息表)】的数据库操作Mapper
 * @createDate 2026-01-22 10:02:44
 * @Entity com.lease.model.entity.LabelInfo
 */
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    List<LabelInfo> getLabelInfoListByApartmentId(Long id);

    List<LabelInfo> selectListByRoomId(Long roomId);
}
