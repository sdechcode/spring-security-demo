package com.sdechcode.springsecuritydemo.security;

import com.sdechcode.springsecuritydemo.user.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JwtProvider jwtProvider;

    public AuthService(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public Map<String, Object> createLoginInfo(Authentication authentication) {
        // Create user info.
        MyUserPrincipal principal = (MyUserPrincipal)authentication.getPrincipal();
        UserEntity user = principal.getUser();
        UserDto userDto = new UserDto(
                user.getId(),
                user.getUsername(),
                user.isEnabled(),
                user.getRoles()
        );

        // Create a JWT.
        String token = this.jwtProvider.createToken(authentication);

        Map<String, Object> loginResultMap = new HashMap<>();

        loginResultMap.put("userInfo", userDto);
        loginResultMap.put("token", token);

        return loginResultMap;
    }

}

record UserDto(
        Integer id,
        String username,
        boolean enabled,
        String roles
) {
}