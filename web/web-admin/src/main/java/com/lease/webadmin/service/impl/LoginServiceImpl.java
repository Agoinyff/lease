package com.lease.webadmin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lease.common.constant.RedisConstant;
import com.lease.common.exception.LeaseException;
import com.lease.common.result.ResultCodeEnum;
import com.lease.common.utils.JwtUtil;
import com.lease.model.entity.SystemUser;
import com.lease.model.enums.BaseStatus;
import com.lease.webadmin.mapper.SystemUserMapper;
import com.lease.webadmin.service.LoginService;
import com.lease.webadmin.vo.login.CaptchaVo;
import com.lease.webadmin.vo.login.LoginVo;
import com.lease.webadmin.vo.system.user.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SystemUserMapper systemUserMapper;



    @Override
    public CaptchaVo generateCaptcha() {




        //创建验证码
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);

        String code = specCaptcha.text().toLowerCase();
        String key = RedisConstant.ADMIN_LOGIN_PREFIX + UUID.randomUUID();

        stringRedisTemplate.opsForValue().set(key,code,RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);  //传入redis缓存，设置过期时间为60秒


        return new CaptchaVo(specCaptcha.toBase64(),key);
    }

    @Override
    public String login(LoginVo loginVo) {

        //进行逻辑判断
        if (loginVo.getCaptchaCode()==null || loginVo.getCaptchaKey()==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }

        String code = stringRedisTemplate.opsForValue().get(loginVo.getCaptchaKey());

        if (code==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }

        if (!code.equals(loginVo.getCaptchaCode().toLowerCase())){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }

        LambdaQueryWrapper<SystemUser> systemUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        systemUserLambdaQueryWrapper.eq(SystemUser::getUsername,loginVo.getUsername());
        SystemUser systemUser = systemUserMapper.selectOne(systemUserLambdaQueryWrapper);
        if (systemUser==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }

        if (systemUser.getStatus()== BaseStatus.DISABLE){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }

        if (!systemUser.getPassword().equals(DigestUtils.md5DigestAsHex(loginVo.getPassword().getBytes()))){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }



        return JwtUtil.createToken(systemUser.getId(),systemUser.getUsername());
    }

    @Override
    public SystemUserInfoVo getById(Long userId) {
        SystemUser systemUser = systemUserMapper.selectById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        BeanUtils.copyProperties(systemUser, systemUserInfoVo);
        return systemUserInfoVo;
    }
}
