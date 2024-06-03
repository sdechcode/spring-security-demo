package com.sdechcode.springsecuritydemo.api.template;

import com.sdechcode.springsecuritydemo.dto.template.TemplateRequestDto;
import com.sdechcode.springsecuritydemo.dto.template.TemplateResponseDto;
import com.sdechcode.springsecuritydemo.entity.TemplateEntity;
import com.sdechcode.springsecuritydemo.repo.TemplateRepository;
import com.sdechcode.springsecuritydemo.system.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;
    private final TemplateMapper templateMapper;

    @Override
    public List<TemplateResponseDto> findAll() {
        List<TemplateEntity> templateEntities = this.templateRepository.findAll();
        return templateEntities.stream()
                .map(t -> new TemplateResponseDto(t.getId(), t.getName(), t.getDescription(), t.getFile()))
                .toList();
    }

    @Override
    public TemplateResponseDto findById(Long templateID) {
        TemplateEntity t = this.templateRepository.findById(templateID)
                .orElseThrow(() -> new ObjectNotFoundException("template", templateID));
        return new TemplateResponseDto(t.getId(), t.getName(), t.getDescription(), t.getFile());
    }

    @Override
    public TemplateResponseDto save(TemplateRequestDto request) {
        TemplateEntity newTemplate = TemplateEntity.builder()
                .name(request.name())
                .description(request.description())
                .file(request.file())
                .build();
        TemplateEntity savedTemplate = this.templateRepository.save(newTemplate);
        return new TemplateResponseDto(savedTemplate.getId(), savedTemplate.getName(), savedTemplate.getDescription(), savedTemplate.getFile());
    }

    @Override
    public TemplateResponseDto update(Long templateID, TemplateRequestDto request) {
        TemplateEntity oldTemplate = this.templateRepository.findById(templateID)
                .orElseThrow(() -> new ObjectNotFoundException("template", templateID));
        oldTemplate.setName(request.name());
        oldTemplate.setDescription(request.description());
        oldTemplate.setFile(request.file());
        TemplateEntity updatedTemplate = this.templateRepository.save(oldTemplate);
        return new TemplateResponseDto(updatedTemplate.getId(), updatedTemplate.getName(), updatedTemplate.getDescription(), updatedTemplate.getFile());
    }

    @Override
    public void delete(Long templateID) {
        this.templateRepository.findById(templateID)
                .orElseThrow(() -> new ObjectNotFoundException("template", templateID));
        this.templateRepository.deleteById(templateID);
    }

}
