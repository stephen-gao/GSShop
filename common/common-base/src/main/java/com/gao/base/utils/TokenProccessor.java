package com.gao.base.utils;

import java.util.UUID;

public class TokenProccessor {

    public static String makeToken(){
        String token = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        return token;
    }
}