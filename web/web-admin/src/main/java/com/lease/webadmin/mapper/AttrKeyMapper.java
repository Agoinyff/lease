package com.lease.webadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lease.model.entity.AttrKey;
import com.lease.webadmin.vo.attr.AttrKeyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author yff
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Mapper
* @createDate 2026-01-22 10:02:43
* @Entity com.lease.model.entity.AttrKey
*/
@Mapper
public interface AttrKeyMapper extends BaseMapper<AttrKey> {

    List<AttrKeyVo> listAttrInfo();
}




