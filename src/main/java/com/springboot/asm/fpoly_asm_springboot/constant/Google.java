package com.springboot.asm.fpoly_asm_springboot.constant;

import org.springframework.beans.factory.annotation.Value;

public class Google {
    public static final String CLIENT_ID = "384241258749-3lk4emo83tf3ndreqrlstj7e1dpv03b1.apps.googleusercontent.com";

    public static final String CLIENT_SECRET = "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";
    public static final String REDIRECT_URI = "http://localhost:5173/login-success";
    public static final String TOKEN_URL = "https://oauth2.googleapis.com/token";
    public static final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json";

    private Google() {
    }
}
