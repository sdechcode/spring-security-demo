package com.sdechcode.springsecuritydemo.api.sms;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/sms")
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String phoneNumber) {
        String otpCode = smsService.generateOtp();
        smsService.sendOtp(phoneNumber, otpCode);
        return ResponseEntity.ok("OTP sent successfully.");
    }

}
