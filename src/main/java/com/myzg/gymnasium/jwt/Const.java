package com.myzg.gymnasium.jwt;

public interface Const {
    public static final String SECRET = "myzg";
    public static final long EXPIRATION_TIME = 432_000_000;//五天（以毫秒计算）
    public static final String TOKEN_HEADER ="token";

}
