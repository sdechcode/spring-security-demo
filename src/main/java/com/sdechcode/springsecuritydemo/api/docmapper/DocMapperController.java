package com.sdechcode.springsecuritydemo.api.docmapper;

import com.sdechcode.springsecuritydemo.system.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/mappers")
@RequiredArgsConstructor
public class DocMapperController {

    private final DocMapperService docMapperService;

    @GetMapping(value = "")
    public Result textReplace() {
        try {
            this.docMapperService.replaceText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Result(true, 200, "Replace text success");
    }

}
