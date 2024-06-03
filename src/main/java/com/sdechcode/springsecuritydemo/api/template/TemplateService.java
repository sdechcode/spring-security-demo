package com.sdechcode.springsecuritydemo.api.template;

import com.sdechcode.springsecuritydemo.dto.template.TemplateRequestDto;
import com.sdechcode.springsecuritydemo.dto.template.TemplateResponseDto;

import java.util.List;

public interface TemplateService {
    List<TemplateResponseDto> findAll();

    TemplateResponseDto findById(Long templateID);

    TemplateResponseDto save(TemplateRequestDto request);

    TemplateResponseDto update(Long templateID, TemplateRequestDto request);

    void delete(Long templateID);
}
