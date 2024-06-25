package com.sdechcode.springsecuritydemo.api.docgen;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/docs-gen")
@RequiredArgsConstructor
public class DocGenController {

}
