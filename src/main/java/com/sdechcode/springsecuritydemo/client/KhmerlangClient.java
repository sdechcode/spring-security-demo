package com.sdechcode.springsecuritydemo.client;

import com.sdechcode.springsecuritydemo.dto.khmerlang.KhmerLangRequestDto;
import com.sdechcode.springsecuritydemo.dto.khmerlang.KhmerLangResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "khmerlang", url = "${khmerlang.client.base-url}")
public interface KhmerlangClient {

    @RequestMapping(method = RequestMethod.POST)
    KhmerLangResponseDto wordSegmentation(KhmerLangRequestDto request);

}
