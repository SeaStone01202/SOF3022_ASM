package com.springboot.asm.fpoly_asm_springboot.security.userdetail;

import com.springboot.asm.fpoly_asm_springboot.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    // Constructor: Nhận đối tượng AppUser
    public CustomUserDetails(User user) {
        this.user = user;
    }

    // Trả về danh sách quyền (authorities)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(String.valueOf(user.getRole())));
    }

    // Trả về email (username) của người dùng
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    // Trả về password
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // Tài khoản chưa hết hạn?
    @Override
    public boolean isAccountNonExpired() {
        return true; // hoặc logic cụ thể nếu có
    }

    // Tài khoản chưa bị khoá?
//    @Override
//    public boolean isAccountNonLocked() {
//        return !user.isLocked(); // Nếu isLocked là true -> tài khoản bị khoá
//    }

    // Mật khẩu chưa hết hạn?
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // hoặc logic cụ thể nếu có
    }

    // Tài khoản có được kích hoạt không?
//    @Override
//    public boolean isEnabled() {
//        return user.isEnabled();
//    }

    // Getter cho AppUser nếu cần sử dụng
    public User getAppUser() {
        return user;
    }
}