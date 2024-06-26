package com.sdechcode.springsecuritydemo.api.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/test")
@Slf4j
public class TestController {

    @GetMapping(value = "")
    public String test() {
        return "testing...!";
    }

}
