package com.sdechcode.springsecuritydemo.api.template;

import com.sdechcode.springsecuritydemo.dto.template.TemplateDto;

import java.util.List;

public interface TemplateService {
    List<TemplateDto> findAll();

    TemplateDto findById(Long templateID);

    TemplateDto save(TemplateDto request);

    TemplateDto update(Long templateID, TemplateDto request);

    void delete(Long templateID);
}
