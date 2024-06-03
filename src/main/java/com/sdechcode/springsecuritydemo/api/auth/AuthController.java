package com.sdechcode.springsecuritydemo.api.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

}
