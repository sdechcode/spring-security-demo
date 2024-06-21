package com.sdechcode.springsecuritydemo.api.document;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/docs")
@RequiredArgsConstructor
public class DocGenController {

}
