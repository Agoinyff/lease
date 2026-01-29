package com.lease.webapp.service;

import com.lease.webapp.vo.user.LoginVo;
import com.lease.webapp.vo.user.UserInfoVo;

public interface LoginService {
    void getCode(String phone);

    String login(LoginVo loginVo);

    UserInfoVo getUserInfoById(Long id);
}
