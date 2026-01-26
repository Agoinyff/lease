package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lease.model.entity.FacilityInfo;
import com.lease.model.enums.ItemType;

import java.util.List;

/**
 * @author yff
 * @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
 * @createDate 2026-01-22 10:02:44
 * @Entity com.lease.model.entity.FacilityInfo
 */
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    List<FacilityInfo> getFacilityInfoListByApartmentId(Long id);

    List<FacilityInfo> selectListByRoomId(Long roomId);
}
