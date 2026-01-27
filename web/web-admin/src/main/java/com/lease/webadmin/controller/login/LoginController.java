package com.lease.webadmin.controller.login;


import com.lease.common.login.LoginUserHolder;
import com.lease.common.result.Result;
import com.lease.common.utils.JwtUtil;
import com.lease.model.entity.SystemUser;
import com.lease.webadmin.service.LoginService;
import com.lease.webadmin.vo.login.CaptchaVo;
import com.lease.webadmin.vo.login.LoginVo;
import com.lease.webadmin.vo.system.user.SystemUserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "获取图形验证码")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {

        CaptchaVo captchaVo = loginService.generateCaptcha();

        return Result.ok(captchaVo);
    }

    @Operation(summary = "登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {

       String token =  loginService.login(loginVo);


        return Result.ok(token);
    }

    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        return Result.ok(loginService.getById(LoginUserHolder.getLoginUser().getId()));
    }
}