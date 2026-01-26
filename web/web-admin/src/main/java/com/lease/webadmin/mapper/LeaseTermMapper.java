package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lease.model.entity.LeaseTerm;

import java.util.List;

/**
 * @author yff
 * @description 针对表【lease_term(租期)】的数据库操作Mapper
 * @createDate 2026-01-22 10:02:44
 * @Entity com.lease.model.entity.LeaseTerm
 */
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {

    List<LeaseTerm> selectListByRoomId(Long roomId);
}
