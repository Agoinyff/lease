package com.lease.common.utils;

import com.lease.common.exception.LeaseException;
import com.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @author yff
 * @date 2026-01-27 11:03:35
 */
public class JwtUtil {

    private static final SecretKey secretKey = Keys
            .hmacShaKeyFor("a-very-long-secret-key-at-least-32-bytes!!!".getBytes());

    public static String createToken(Long userId, String username) {
        return Jwts.builder()
                .expiration(new Date(System.currentTimeMillis() + 3600000*24*365L)) // 过期时间 1小时
                .subject("LOGIN_USER")
                .claim("userId", userId)
                .claim("username", username)
                .signWith(secretKey)
                .compact();
    }

    /**
     * 解析 Token 获取 userId
     */
    public static Long getUserId(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("userId", Long.class);
    }

    /**
     * 解析 Token 获取 username
     */
    public static String getUsername(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("username", String.class);
    }


    //解析 Token 看看是否合法
    public static void isTokenValid(String token) {

        if (token == null || token.isEmpty()) {
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }
        try {
            Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token);
        } catch (ExpiredJwtException e) {
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED); //token过期
        } catch (JwtException e) {
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID); //token非法
        }
    }



}
