package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lease.model.entity.ViewAppointment;
import com.lease.webadmin.vo.appointment.AppointmentQueryVo;
import com.lease.webadmin.vo.appointment.AppointmentVo;

/**
* @author yff
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
* @createDate 2026-01-22 10:02:44
* @Entity com.lease.model.entity.ViewAppointment
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    IPage<AppointmentVo> pageAppointmentVo(Page<AppointmentVo> appointmentVoPage, AppointmentQueryVo queryVo);
}




