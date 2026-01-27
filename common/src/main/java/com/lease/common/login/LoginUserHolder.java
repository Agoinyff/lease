package com.lease.common.login;


/**
 * @author yff
 * @date 2026-01-27 14:14:21
 */
public class LoginUserHolder {

    public static final ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();


    public static void setLoginUser(LoginUser loginUser) {
        threadLocal.set(loginUser);
    }

    public static LoginUser getLoginUser() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }



}
