package com.lease.webadmin.custom.interceptor;


import com.lease.common.exception.LeaseException;
import com.lease.common.login.LoginUser;
import com.lease.common.login.LoginUserHolder;
import com.lease.common.result.ResultCodeEnum;
import com.lease.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;

/**
 * @author yff
 * @date 2026-01-27 13:38:55
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {


    //在请求处理之前进行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("access-token");

        JwtUtil.isTokenValid(token);

        //解析token，拿到用户信息
        Long userId = JwtUtil.getUserId(token);
        String username = JwtUtil.getUsername(token);
        LoginUserHolder.setLoginUser(new LoginUser(userId,username)); //保存到全局线程变量中

        return true;

    }

    //请求处理完之后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserHolder.clear(); //清除线程变量，防止内存泄漏
    }
}
