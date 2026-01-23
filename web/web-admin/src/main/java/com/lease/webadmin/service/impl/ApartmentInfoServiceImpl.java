package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.*;
import com.lease.model.enums.ItemType;
import com.lease.webadmin.mapper.ApartmentInfoMapper;
import com.lease.webadmin.service.*;
import com.lease.webadmin.vo.apartment.ApartmentDetailVo;
import com.lease.webadmin.vo.apartment.ApartmentItemVo;
import com.lease.webadmin.vo.apartment.ApartmentQueryVo;
import com.lease.webadmin.vo.apartment.ApartmentSubmitVo;
import com.lease.webadmin.vo.graph.GraphVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

import java.util.List;

/**
 * @author yff
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2026-01-22 10:02:43
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;

    @Autowired
    private GraphInfoService graphInfoService;

    @Autowired
    private ApartmentFacilityService apartmentFacilityService;

    @Autowired
    private ApartmentLabelService apartmentLabelService;

    @Autowired
    private ApartmentFeeValueService apartmentFeeValueService;

    @Override
    public void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo) {

        //由于我们的新增和修改公寓信息的操做逻辑是不太一样的，所以我们要先判断是否是新增还是修改
        boolean isUpdate = apartmentSubmitVo.getId() != null;
        super.saveOrUpdate(apartmentSubmitVo); //调用父类的方法保存或更新公寓信息  处理的是ApartmentInfo实体类对应的表数据

        if (isUpdate) {
            //修改操作  先删除公寓相关的关联数据
            //1.删除图片列表
            LambdaQueryWrapper<GraphInfo> graphInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemType, ItemType.APARTMENT);
            graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemId, apartmentSubmitVo.getId());
            graphInfoService.remove(graphInfoLambdaQueryWrapper);
            //2.删除配套列表
            LambdaQueryWrapper<ApartmentFacility> apartmentFacilityLambdaQueryWrapper = new LambdaQueryWrapper<>();
            apartmentFacilityLambdaQueryWrapper.eq(ApartmentFacility::getApartmentId, apartmentSubmitVo.getId());
            apartmentFacilityService.remove(apartmentFacilityLambdaQueryWrapper);
            //3.删除标签列表
            LambdaQueryWrapper<ApartmentLabel> apartmentLabelLambdaQueryWrapper = new LambdaQueryWrapper<>();
            apartmentLabelLambdaQueryWrapper.eq(ApartmentLabel::getApartmentId, apartmentSubmitVo.getId());
            apartmentLabelService.remove(apartmentLabelLambdaQueryWrapper);
            //4.删除杂费值列表
            LambdaQueryWrapper<ApartmentFeeValue> apartmentFeeValueLambdaQueryWrapper = new LambdaQueryWrapper<>();
            apartmentFeeValueLambdaQueryWrapper.eq(ApartmentFeeValue::getApartmentId, apartmentSubmitVo.getId());
            apartmentFeeValueService.remove(apartmentFeeValueLambdaQueryWrapper);
        }

        //插入图片列表
        List<GraphVo> graphVoList = apartmentSubmitVo.getGraphVoList();
        if (!CollectionUtils.isEmpty(graphVoList)){   //判断集合是否非空
            //这里要进行一个类型转换，把Vo转换为实体类
            ArrayList<GraphInfo> graphInfoList = new ArrayList<>();
            for (GraphVo graphVo : graphVoList) {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setName(graphVo.getName());
                graphInfo.setUrl(graphVo.getUrl());
                graphInfo.setItemType(ItemType.APARTMENT);
                graphInfo.setItemId(apartmentSubmitVo.getId());
                graphInfoList.add(graphInfo);
            }
            graphInfoService.saveBatch(graphInfoList);
        }

        //插入配套列表
        List<Long> facilityInfoIdList = apartmentSubmitVo.getFacilityInfoIds();
        if (!CollectionUtils.isEmpty(facilityInfoIdList)) {
            ArrayList<ApartmentFacility> facilitiesList = new ArrayList<>();
            for (Long facilityId : facilityInfoIdList) {
                ApartmentFacility apartmentFacility = new ApartmentFacility();
                apartmentFacility.setApartmentId(apartmentSubmitVo.getId());
                apartmentFacility.setFacilityId(facilityId);
                facilitiesList.add(apartmentFacility);
            }
            apartmentFacilityService.saveBatch(facilitiesList);
        }

        //插入标签列表
        List<Long> labelIdList = apartmentSubmitVo.getLabelIds();
        if (!CollectionUtils.isEmpty(labelIdList)) {
            ArrayList<ApartmentLabel> labelList = new ArrayList<>();
            for (Long labelId : labelIdList) {
                ApartmentLabel apartmentLabel = new ApartmentLabel();
                apartmentLabel.setApartmentId(apartmentSubmitVo.getId());
                apartmentLabel.setLabelId(labelId);
                labelList.add(apartmentLabel);
            }
            apartmentLabelService.saveBatch(labelList);
        }

        //插入杂费值列表
        List<Long> feeValueIdList = apartmentSubmitVo.getFeeValueIds();
        if (!CollectionUtils.isEmpty(feeValueIdList)) {
            ArrayList<ApartmentFeeValue> feeValueList = new ArrayList<>();
            for (Long feeValueId : feeValueIdList) {
                ApartmentFeeValue apartmentFeeValue = new ApartmentFeeValue();
                apartmentFeeValue.setApartmentId(apartmentSubmitVo.getId());
                apartmentFeeValue.setFeeValueId(feeValueId);
                feeValueList.add(apartmentFeeValue);
            }
            apartmentFeeValueService.saveBatch(feeValueList);
        }



    }

    @Override
    public IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo) {
        return apartmentInfoMapper.pageItem(page, queryVo);


    }

    @Override
    public ApartmentDetailVo getDetailById(Long id) {

       return apartmentInfoMapper.getDetailById(id);


    }
}
