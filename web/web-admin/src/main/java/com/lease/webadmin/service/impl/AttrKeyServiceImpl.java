package com.lease.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lease.model.entity.AttrKey;
import com.lease.webadmin.mapper.AttrKeyMapper;
import com.lease.webadmin.service.AttrKeyService;
import com.lease.webadmin.vo.attr.AttrKeyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yff
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service实现
* @createDate 2026-01-22 10:02:43
*/
@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey>
    implements AttrKeyService {

    @Autowired
    private AttrKeyMapper attrKeyMapper;


    @Override
    public List<AttrKeyVo> listAttrInfo() {
        return attrKeyMapper.listAttrInfo();
    }
}




