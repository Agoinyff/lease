package com.lease.common.utils;

import java.util.Random;

/**
 * 验证码生成工具类
 * 
 * @author yff
 * @date 2026-01-28
 */
public class CodeUtil {

    private static final Random RANDOM = new Random();

    /**
     * 生成指定长度的数字验证码
     * 
     * @param length 验证码长度
     * @return 验证码字符串
     */
    public static String generateCode(int length) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            code.append(RANDOM.nextInt(10));
        }
        return code.toString();
    }

    /**
     * 生成6位数字验证码（默认）
     * 
     * @return 6位验证码
     */
    public static String generateCode() {
        return generateCode(6);
    }

    /**
     * 生成4位数字验证码
     * 
     * @return 4位验证码
     */
    public static String generateCode4() {
        return generateCode(4);
    }
}
