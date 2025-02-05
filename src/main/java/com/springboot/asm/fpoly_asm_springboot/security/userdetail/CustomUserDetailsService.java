package com.springboot.asm.fpoly_asm_springboot.security.userdetail;

import com.springboot.asm.fpoly_asm_springboot.entities.User;
import com.springboot.asm.fpoly_asm_springboot.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);
        return new CustomUserDetails(user);
    }
}
