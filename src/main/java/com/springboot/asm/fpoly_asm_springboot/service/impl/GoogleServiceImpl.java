package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.springboot.asm.fpoly_asm_springboot.constant.Google;
import com.springboot.asm.fpoly_asm_springboot.service.GoogleService;
import org.springframework.stereotype.Service;

@Service
public class GoogleServiceImpl implements GoogleService {

    @Override
    public String getAccessToken(String code) throws Exception {
        GoogleTokenResponse response = new GoogleAuthorizationCodeTokenRequest(
                new NetHttpTransport(),
                new GsonFactory(),
                "https://oauth2.googleapis.com/token",
                Google.CLIENT_ID,
                Google.CLIENT_SECRET,
                code,
                Google.REDIRECT_URI
        ).execute();

        return response.getAccessToken();
    }
}
