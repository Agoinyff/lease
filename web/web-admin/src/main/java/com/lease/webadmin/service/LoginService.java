package com.lease.webadmin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lease.model.entity.SystemUser;
import com.lease.model.entity.UserInfo;
import com.lease.webadmin.vo.login.CaptchaVo;
import com.lease.webadmin.vo.login.LoginVo;
import com.lease.webadmin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo generateCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getById(Long userId);
}
