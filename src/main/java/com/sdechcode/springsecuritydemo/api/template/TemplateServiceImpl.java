package com.sdechcode.springsecuritydemo.api.template;

import com.sdechcode.springsecuritydemo.dto.template.TemplateDto;
import com.sdechcode.springsecuritydemo.repo.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    @Override
    public List<TemplateDto> findAll() {
        return List.of();
    }

    @Override
    public TemplateDto findById(Long templateID) {
        return null;
    }

    @Override
    public TemplateDto save(TemplateDto request) {
        return null;
    }

    @Override
    public TemplateDto update(Long templateID, TemplateDto request) {
        return null;
    }

    @Override
    public void delete(Long templateID) {

    }

}
