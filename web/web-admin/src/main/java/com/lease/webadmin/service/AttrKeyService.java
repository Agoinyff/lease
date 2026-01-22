package com.lease.webadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lease.model.entity.AttrKey;
import com.lease.webadmin.vo.attr.AttrKeyVo;

import java.util.List;

/**
* @author yff
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service
* @createDate 2026-01-22 10:02:43
*/
public interface AttrKeyService extends IService<AttrKey> {


    List<AttrKeyVo> listAttrInfo();
}
