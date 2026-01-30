package com.lease.webapp.service.serviceimpl;

import com.lease.model.entity.ApartmentInfo;
import com.lease.model.entity.FacilityInfo;
import com.lease.model.entity.LabelInfo;
import com.lease.model.enums.ItemType;
import com.lease.webapp.mapper.*;
import com.lease.webapp.service.ApartmentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.webapp.vo.apartment.ApartmentDetailVo;
import com.lease.webapp.vo.apartment.ApartmentItemVo;
import com.lease.webapp.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liubo
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private RoomInfoMapper roomInfoMapper;

    @Autowired
    private FacilityInfoMapper facilityInfoMapper;

    @Override
    public ApartmentItemVo selectApartmentItemVoById(Long apartmentId) {
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(apartmentId);

        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByApartmentId(apartmentId);

        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, apartmentId);

        BigDecimal minRent = roomInfoMapper.selectMinRentByApartmentId(apartmentId);

        ApartmentItemVo apartmentItemVo = new ApartmentItemVo();
        BeanUtils.copyProperties(apartmentInfo, apartmentItemVo);

        apartmentItemVo.setGraphVoList(graphVoList);
        apartmentItemVo.setLabelInfoList(labelInfoList);
        apartmentItemVo.setMinRent(minRent);
        return apartmentItemVo;
    }

    @Override
    public ApartmentDetailVo getDetailById(Long id) {
        ApartmentDetailVo apartmentDetailVo = new ApartmentDetailVo();

        ApartmentItemVo apartmentItemVo = this.selectApartmentItemVoById(id);
        BeanUtils.copyProperties(apartmentItemVo, apartmentDetailVo);

        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByApartmentId(id);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);

        return apartmentDetailVo;
    }
}




