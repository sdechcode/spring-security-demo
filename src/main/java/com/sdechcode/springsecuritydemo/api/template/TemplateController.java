package com.sdechcode.springsecuritydemo.api.template;

import com.sdechcode.springsecuritydemo.dto.template.TemplateDto;
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
        List<TemplateDto> templates = templateService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find all success", templates);
    }

    @GetMapping(value = "/{templateID}")
    public Result findTemplateByID(@PathVariable(name = "templateID") Long templateID) {
        TemplateDto template = templateService.findById(templateID);
        return new Result(true, StatusCode.SUCCESS, "Find one success", template);
    }

    @PostMapping(value = "")
    public Result addTemplate(@Valid @RequestBody TemplateDto request) {
        TemplateDto templateDto = templateService.save(request);
        return new Result(true, StatusCode.SUCCESS, "Add success", templateDto);
    }

    @PutMapping(value = "/{templateID}")
    public Result updateTemplate(@PathVariable(name = "templateID") Long templateID, @Valid @RequestBody TemplateDto request) {
        TemplateDto templateDto = templateService.update(templateID, request);
        return new Result(true, StatusCode.SUCCESS, "Update success", templateDto);
    }

    @DeleteMapping(value = "/{templateID}")
    public Result deleteTemplate(@PathVariable(name = "templateID") Long templateID) {
        templateService.delete(templateID);
        return new Result(true, StatusCode.SUCCESS, "Delete success");
    }

}
