package com.lease.webapp.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lease.common.login.LoginUserHolder;
import com.lease.model.entity.UserInfo;
import com.lease.model.entity.ViewAppointment;
import com.lease.webapp.mapper.UserInfoMapper;
import com.lease.webapp.mapper.ViewAppointmentMapper;
import com.lease.webapp.service.ApartmentInfoService;
import com.lease.webapp.service.ViewAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.webapp.vo.apartment.ApartmentItemVo;
import com.lease.webapp.vo.appointment.AppointmentDetailVo;
import com.lease.webapp.vo.appointment.AppointmentItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liubo
 * @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
 * @createDate 2023-07-26 11:12:39
 */
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ViewAppointmentMapper viewAppointmentMapper;

    @Autowired
    private ApartmentInfoService apartmentInfoService;

    @Override
    public List<AppointmentItemVo> listItem() {

        LambdaQueryWrapper<UserInfo> userInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userInfoLambdaQueryWrapper.eq(UserInfo::getId, LoginUserHolder.getLoginUser().getId());
        UserInfo userInfo = userInfoMapper.selectOne(userInfoLambdaQueryWrapper);

        List<AppointmentItemVo> appointmentItemVoList = viewAppointmentMapper.listItem(userInfo.getId());

        return List.of();
    }

    @Override
    public AppointmentDetailVo getDetailById(Long id) {
//查询后copy构造
        ViewAppointment viewAppointment = viewAppointmentMapper.selectById(id);

        ApartmentItemVo apartmentItemVo = apartmentInfoService.selectApartmentItemVoById(viewAppointment.getApartmentId());

        AppointmentDetailVo agreementDetailVo = new AppointmentDetailVo();
        BeanUtils.copyProperties(viewAppointment, agreementDetailVo);

        agreementDetailVo.setApartmentItemVo(apartmentItemVo);

        return agreementDetailVo;
    }
}




