package com.sdechcode.springsecuritydemo.api.test;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/test")
public class TestController {

    @GetMapping(value = "")
    public String test() {
        return "testing...!";
    }

    // Return a file after processed
    @GetMapping(value = "/return-file")
    public void testFile(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("CERTIFICATE.docx");
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}
