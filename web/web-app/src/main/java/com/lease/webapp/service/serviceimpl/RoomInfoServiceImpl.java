package com.lease.webapp.service.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lease.common.login.LoginUserHolder;
import com.lease.model.entity.*;
import com.lease.model.enums.ItemType;
import com.lease.webapp.mapper.*;
import com.lease.webapp.service.BrowsingHistoryService;
import com.lease.webapp.service.RoomInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.webapp.vo.apartment.ApartmentItemVo;
import com.lease.webapp.vo.attr.AttrValueVo;
import com.lease.webapp.vo.fee.FeeValueVo;
import com.lease.webapp.vo.graph.GraphVo;
import com.lease.webapp.vo.room.RoomDetailVo;
import com.lease.webapp.vo.room.RoomItemVo;
import com.lease.webapp.vo.room.RoomQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liubo
 * @description 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
@Slf4j
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private LeaseTermMapper leaseTermMapper;
    @Autowired
    private FacilityInfoMapper facilityInfoMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Autowired
    private AttrValueMapper attrValueMapper;
    @Autowired
    private FeeValueMapper feeValueMapper;
    @Autowired
    private ApartmentInfoServiceImpl apartmentInfoService;
    @Autowired
    private BrowsingHistoryService browsingHistoryService;

    @Override
    public IPage<RoomItemVo> pageItemVo(Page<RoomItemVo> roomItemVoPage, RoomQueryVo queryVo) {

        return roomInfoMapper.pageItem(roomItemVoPage, queryVo);
    }

    @Override
    public RoomDetailVo getDetailById(Long id) {


        //1.查询房间信息
        RoomInfo roomInfo = roomInfoMapper.selectById(id);
        if (roomInfo == null) {
            return null;
        }
        //2.查询图片
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, id);
        //3.查询租期
        List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoomId(id);
        //4.查询配套
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);
        //5.查询标签
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(id);
        //6.查询支付方式
        List<PaymentType> paymentTypeList = paymentTypeMapper.selectListByRoomId(id);
        //7.查询基本属性
        List<AttrValueVo> attrValueVoList = attrValueMapper.selectListByRoomId(id);
        //8.查询杂费信息
        List<FeeValueVo> feeValueVoList = feeValueMapper.selectListByApartmentId(roomInfo.getApartmentId());
        //9.查询公寓信息
        ApartmentItemVo apartmentItemVo = apartmentInfoService.selectApartmentItemVoById(roomInfo.getApartmentId());

        RoomDetailVo roomDetailVo = new RoomDetailVo();
        BeanUtils.copyProperties(roomInfo, roomDetailVo);

        roomDetailVo.setApartmentItemVo(apartmentItemVo);
        roomDetailVo.setGraphVoList(graphVoList);
        roomDetailVo.setAttrValueVoList(attrValueVoList);
        roomDetailVo.setFacilityInfoList(facilityInfoList);
        roomDetailVo.setLabelInfoList(labelInfoList);
        roomDetailVo.setPaymentTypeList(paymentTypeList);
        roomDetailVo.setFeeValueVoList(feeValueVoList);
        roomDetailVo.setLeaseTermList(leaseTermList);


        browsingHistoryService.saveHistory(LoginUserHolder.getLoginUser().getId(), id);



        return roomDetailVo;
    }

    @Override
    public IPage<RoomItemVo> pageItemByApartmentId(Page<RoomItemVo> roomItemVoPage, Long id) {

       return roomInfoMapper.pageItemByApartmentId(roomItemVoPage, id);

    }
}




