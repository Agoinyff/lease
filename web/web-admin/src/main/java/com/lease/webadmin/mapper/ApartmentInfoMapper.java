package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lease.model.entity.ApartmentInfo;
import com.lease.webadmin.vo.apartment.ApartmentDetailVo;
import com.lease.webadmin.vo.apartment.ApartmentItemVo;
import com.lease.webadmin.vo.apartment.ApartmentQueryVo;

/**
* @author yff
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
* @createDate 2026-01-22 10:02:43
* @Entity com.lease.model.entity.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo);

    ApartmentDetailVo getDetailById(Long id);
}




