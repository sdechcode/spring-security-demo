package com.sdechcode.springsecuritydemo.api.sms;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;
    private final TwilioRestClient twilioRestClient;

    @Autowired
    public SmsService(@Value("${twilio.accountSid}") String accountSid, @Value("${twilio.authToken}") String authToken) {
        twilioRestClient = new TwilioRestClient.Builder(accountSid, authToken).build();
    }

    public String generateOtp() {
        return "123456";
    }

    public void sendOtp(String recipientPhoneNumber, String otpCode) {
        Message.creator(new PhoneNumber(recipientPhoneNumber), new PhoneNumber(twilioPhoneNumber),
                        "Your OTP code is: " + otpCode)
                .create(twilioRestClient);
    }

}
