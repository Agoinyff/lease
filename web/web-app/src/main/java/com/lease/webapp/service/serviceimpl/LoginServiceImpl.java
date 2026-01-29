package com.lease.webapp.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lease.common.constant.RedisConstant;
import com.lease.common.exception.LeaseException;
import com.lease.common.result.ResultCodeEnum;
import com.lease.common.utils.CodeUtil;
import com.lease.common.utils.JwtUtil;
import com.lease.model.entity.UserInfo;
import com.lease.model.enums.BaseStatus;
import com.lease.webapp.mapper.UserInfoMapper;
import com.lease.webapp.service.LoginService;
import com.lease.webapp.service.SmsService;
import com.lease.webapp.vo.user.LoginVo;
import com.lease.webapp.vo.user.UserInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SmsService smsService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /// 获取登录验证码
    @Override
    public void getCode(String phone) {

        String code = CodeUtil.generateCode();
        String key = RedisConstant.APP_LOGIN_PREFIX + phone;

        Boolean hasKey = stringRedisTemplate.hasKey(key);
        if (hasKey) { // 判断验证码是否发送频繁
            Long expire = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
            if (RedisConstant.APP_LOGIN_CODE_TTL_SEC - expire < RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC) {
                throw new LeaseException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
            }
        }
        // 发送短信
        smsService.sendCode(phone, code);

        stringRedisTemplate.opsForValue().set(key, code, RedisConstant.APP_LOGIN_CODE_TTL_SEC, TimeUnit.SECONDS);
    }

    @Override
    public String login(LoginVo loginVo) {
        // String key = RedisConstant.APP_LOGIN_PREFIX + loginVo.getPhone();

        // 校验非空
        if (loginVo == null || StringUtils.isEmpty(loginVo.getPhone()) || StringUtils.isEmpty(loginVo.getCode())) {
            throw new LeaseException(ResultCodeEnum.PARAM_ERROR);
        }

        String code = stringRedisTemplate.opsForValue().get(RedisConstant.APP_LOGIN_PREFIX + loginVo.getPhone());
        if (code == null) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EXPIRED);
        }
        if (!code.equals(loginVo.getCode())) {
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }

        LambdaQueryWrapper<UserInfo> userInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userInfoLambdaQueryWrapper.eq(UserInfo::getPhone, loginVo.getPhone());
        UserInfo userInfo = userInfoMapper.selectOne(userInfoLambdaQueryWrapper);
        if (userInfo == null) {
            // 注册
            userInfo = new UserInfo();
            userInfo.setPhone(loginVo.getPhone());
            userInfo.setNickname("用户-"+loginVo.getPhone().substring(7));
            userInfo.setStatus(BaseStatus.ENABLE);
            userInfoMapper.insert(userInfo);
        }else{
            //禁用？
            if (userInfo.getStatus() == BaseStatus.DISABLE) {
                throw new LeaseException(ResultCodeEnum.APP_ACCOUNT_DISABLED_ERROR);
            }
        }



        return JwtUtil.createToken(userInfo.getId(), userInfo.getPhone());
    }

    @Override
    public UserInfoVo getUserInfoById(Long id) {

        UserInfo userInfo = userInfoMapper.selectById(id);

        return new UserInfoVo(userInfo.getPhone(), userInfo.getNickname());
    }
}
