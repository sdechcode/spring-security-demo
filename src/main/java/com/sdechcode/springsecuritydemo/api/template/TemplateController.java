package com.sdechcode.springsecuritydemo.api.template;

import com.sdechcode.springsecuritydemo.dto.template.TemplateRequestDto;
import com.sdechcode.springsecuritydemo.dto.template.TemplateResponseDto;
import com.sdechcode.springsecuritydemo.system.Result;
import com.sdechcode.springsecuritydemo.system.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint.base-url}/templates")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    @GetMapping(value = "")
    public Result findAllTemplates() {
        List<TemplateResponseDto> templates = templateService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find all success", templates);
    }

    @GetMapping(value = "/{templateID}")
    public Result findTemplateByID(@PathVariable(name = "templateID") Long templateID) {
        TemplateResponseDto template = templateService.findById(templateID);
        return new Result(true, StatusCode.SUCCESS, "Find one success", template);
    }

    @PostMapping(value = "")
    public Result addTemplate(@Valid @RequestBody TemplateRequestDto request) {
        TemplateResponseDto templateDto = templateService.save(request);
        return new Result(true, StatusCode.SUCCESS, "Add success", templateDto);
    }

    @PutMapping(value = "/{templateID}")
    public Result updateTemplate(@PathVariable(name = "templateID") Long templateID, @Valid @RequestBody TemplateRequestDto request) {
        TemplateResponseDto templateDto = templateService.update(templateID, request);
        return new Result(true, StatusCode.SUCCESS, "Update success", templateDto);
    }

    @DeleteMapping(value = "/{templateID}")
    public Result deleteTemplate(@PathVariable(name = "templateID") Long templateID) {
        templateService.delete(templateID);
        return new Result(true, StatusCode.SUCCESS, "Delete success");
    }

}
