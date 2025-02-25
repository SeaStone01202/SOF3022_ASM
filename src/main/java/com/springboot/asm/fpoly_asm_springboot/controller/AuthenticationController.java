package com.springboot.asm.fpoly_asm_springboot.controller;

import com.nimbusds.jose.JOSEException;
import com.springboot.asm.fpoly_asm_springboot.constant.Google;
import com.springboot.asm.fpoly_asm_springboot.constant.Role;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.AuthenticationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.IntrospectRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.AuthenticationResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.IntrospectResponse;

import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.service.*;
import lombok.RequiredArgsConstructor;
import com.springboot.asm.fpoly_asm_springboot.dto.request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final GoogleService googleService;
    private final UserService userService;

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authenticationResponseApiResponse(@RequestBody AuthenticationRequest request) {

        var result = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder().
                result(result).
                build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {

        var result = authenticationService.introspect(request);

        return ApiResponse.<IntrospectResponse>builder().result(result).build();
    }

    @PostMapping("/logout")
    ApiResponse<?> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {

        authenticationService.logout(request);

        return ApiResponse.<String>builder().
                result("Account is logged out successfully ").
                build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationResponse> refresh(@RequestBody RefreshRequest request) throws ParseException, JOSEException {
        return ApiResponse.<AuthenticationResponse>builder().
                result(authenticationService.refreshToken(request)).
                build();
    }

    @PostMapping("/callback")
    public ResponseEntity<?> handleGoogleCallback(@RequestBody Map<String, String> requestData) {
        String code = requestData.get("code");

        if (code == null) {
            return ResponseEntity.badRequest().body("Lỗi: Không tìm thấy mã code!");
        }

        try {
            String accessToken = googleService.getAccessToken(code);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + accessToken);
            HttpEntity<String> userEntity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map> userInfoResponse = restTemplate.exchange(
                    "https://www.googleapis.com/oauth2/v3/userinfo",
                    HttpMethod.GET,
                    userEntity,
                    Map.class
            );
            Map<String, Object> userInfo = userInfoResponse.getBody();
            if (userInfo == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi lấy thông tin user");
            }

            User userGG = User.builder()
                    .email((String) userInfo.get("email"))
                    .fullName((String) userInfo.get("name"))
                    .avatar((String) userInfo.get("picture"))
                    .phone((String) userInfo.get("phone"))
                    .role(Role.USER)
                    .build();

            String jwtToken = authenticationService.generateToken(authenticationService.getOrCreateUser(userGG));

            Map<String, Object> response = new HashMap<>();
            response.put("google_access_token", accessToken);
            response.put("jwt_token", jwtToken);
            response.put("user_info", userInfo);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi xử lý OAuth2: " + e.getMessage());
        }
    }
}
