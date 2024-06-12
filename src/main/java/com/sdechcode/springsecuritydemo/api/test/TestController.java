package com.sdechcode.springsecuritydemo.api.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/test")
public class TestController {

    @GetMapping(value = "")
    public String test() {
        return "testing...!";
    }

}
