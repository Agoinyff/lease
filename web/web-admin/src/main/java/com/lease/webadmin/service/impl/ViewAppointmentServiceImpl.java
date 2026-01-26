package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.ViewAppointment;
import com.lease.webadmin.mapper.ViewAppointmentMapper;
import com.lease.webadmin.service.ViewAppointmentService;
import com.lease.webadmin.vo.appointment.AppointmentQueryVo;
import com.lease.webadmin.vo.appointment.AppointmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author yff
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:44
*/
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
    implements ViewAppointmentService {

    @Autowired
    private ViewAppointmentMapper viewAppointmentMapper;

    @Override
    public IPage<AppointmentVo> pageAppointmentVo(Page<AppointmentVo> appointmentVoPage, AppointmentQueryVo queryVo) {


        return viewAppointmentMapper.pageAppointmentVo(appointmentVoPage, queryVo);
    }
}




