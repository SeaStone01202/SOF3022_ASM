package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.service.MailService;
import com.springboot.asm.fpoly_asm_springboot.util.UrlUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    private final UrlUtil urlUtil;

    @Value("spring.mail.username")
    private String from;

    @Override
    public void sendForgotPasswordMail(HttpServletRequest request,String token) {

        String emailTo = request.getParameter("email");

        String urlReset = urlUtil.buildResetPasswordLink(request,token);

        String subject = "Reset Password Request";
        String body = "Bạn đã yêu cầu đặt lại mật khẩu. Vui lòng nhấn vào link dưới đây để đặt lại mật khẩu của bạn:\n"
                + token + "\n\nLink sẽ hết hạn sau 10 phút.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(emailTo);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
