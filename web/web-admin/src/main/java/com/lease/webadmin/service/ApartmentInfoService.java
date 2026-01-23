package com.lease.webadmin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lease.model.entity.ApartmentInfo;
import com.lease.webadmin.vo.apartment.ApartmentDetailVo;
import com.lease.webadmin.vo.apartment.ApartmentItemVo;
import com.lease.webadmin.vo.apartment.ApartmentQueryVo;
import com.lease.webadmin.vo.apartment.ApartmentSubmitVo;

/**
 * @author yff
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
 * @createDate 2026-01-22 10:02:43
 */
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo);

    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo);

    ApartmentDetailVo getDetailById(Long id);
}
