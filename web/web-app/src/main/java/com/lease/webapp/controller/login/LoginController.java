package com.lease.webapp.controller.login;


import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.lease.common.login.LoginUserHolder;
import com.lease.common.result.Result;
import com.aliyun.dysmsapi20170525.Client;
import com.lease.webapp.service.LoginService;
import com.lease.webapp.service.SmsService;
import com.lease.webapp.vo.user.LoginVo;
import com.lease.webapp.vo.user.UserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录管理")
@RestController
@RequestMapping("/app/")
public class LoginController {

    @Autowired
    private LoginService  loginService;

    @GetMapping("login/getCode")
    @Operation(summary = "获取短信验证码")
    public Result getCode(@RequestParam String phone) {

        loginService.getCode(phone);

        return Result.ok();
    }

    @PostMapping("login")
    @Operation(summary = "登录")
    public Result<String> login(@RequestBody LoginVo loginVo) {

       String token =  loginService.login(loginVo);
        return Result.ok(token);
    }

    @GetMapping("info")
    @Operation(summary = "获取登录用户信息")
    public Result<UserInfoVo> info() {

        UserInfoVo userInfoVo = loginService.getUserInfoById(LoginUserHolder.getLoginUser().getId());


        return Result.ok(userInfoVo);
    }
}

