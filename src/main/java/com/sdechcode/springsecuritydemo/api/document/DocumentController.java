package com.sdechcode.springsecuritydemo.api.document;

import com.sdechcode.springsecuritydemo.system.Result;
import com.sdechcode.springsecuritydemo.system.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocxNaiveTextReplacer docxNaiveTextReplacer;

    @GetMapping(value = "/text-replacer")
    public Result docxTextReplacer() {
        try {
            this.docxNaiveTextReplacer.replaceText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Result(true, StatusCode.SUCCESS, "Replace text success");
    }

}
