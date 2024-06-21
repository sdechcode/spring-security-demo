package com.sdechcode.springsecuritydemo.api.template;

import com.sdechcode.springsecuritydemo.dto.template.TemplateRequestDto;
import com.sdechcode.springsecuritydemo.dto.template.TemplateResponseDto;
import com.sdechcode.springsecuritydemo.entity.TemplateEntity;
import com.sdechcode.springsecuritydemo.repo.TemplateRepository;
import com.sdechcode.springsecuritydemo.system.exception.ObjectNotFoundException;
import com.sdechcode.springsecuritydemo.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    @Override
    public List<TemplateResponseDto> findAll() {
        List<TemplateEntity> templateEntities = this.templateRepository.findAll();
        return templateEntities.stream()
                .map(t -> new TemplateResponseDto(t.getId(), t.getName(), t.getDescription(), t.getJsonData(), t.getFile())).toList();
    }

    @Override
    public TemplateResponseDto findById(Long templateID) {
        TemplateEntity t = this.templateRepository.findById(templateID)
                .orElseThrow(() -> new ObjectNotFoundException("template", templateID));
        return new TemplateResponseDto(t.getId(), t.getName(), t.getDescription(), t.getJsonData(), t.getFile());
    }

    @Override
    public TemplateResponseDto save(TemplateRequestDto request) {
        TemplateEntity newTemplate = TemplateEntity.builder()
                .name(request.name())
                .description(request.description())
                .jsonData(JsonUtil.object2Json(request.jsonData()))
                .file(request.file())
                .build();
        TemplateEntity savedTemplate = this.templateRepository.save(newTemplate);
        log.info("saved template {}", savedTemplate.getJsonData());

        // TODO: After saved template it should response the json string back to the response
        return new TemplateResponseDto(savedTemplate.getId(), savedTemplate.getName(), savedTemplate.getDescription(), newTemplate.getJsonData(), savedTemplate.getFile());
    }

    @Override
    public TemplateResponseDto update(Long templateID, TemplateRequestDto request) {
        TemplateEntity oldTemplate = this.templateRepository.findById(templateID)
                .orElseThrow(() -> new ObjectNotFoundException("template", templateID));
        oldTemplate.setName(request.name());
        oldTemplate.setDescription(request.description());
        oldTemplate.setJsonData(JsonUtil.object2Json(request.jsonData()));
        oldTemplate.setFile(request.file());
        TemplateEntity updatedTemplate = this.templateRepository.save(oldTemplate);
        return new TemplateResponseDto(updatedTemplate.getId(), updatedTemplate.getName(), updatedTemplate.getDescription(), updatedTemplate.getJsonData(), updatedTemplate.getFile());
    }

    @Override
    public void delete(Long templateID) {
        this.templateRepository.findById(templateID).orElseThrow(() -> new ObjectNotFoundException("template", templateID));
        this.templateRepository.deleteById(templateID);
    }

}

/*Map<String, Object> response1 = JsonUtil.object2Map(request.jsonData());
        Map<String, Object> response2 = JsonUtil.object2Map(response1.get("willingnessPurposeMasterDegree"));
        Map<String, Object> response3 = JsonUtil.object2Map(response2.get("pleaseConfirmPurposeChoosingAboveSkillsEducationalInstitutions"));
        log.info("Response 3: {} ", response3.get("value"));

        Map<String, Object> response = JsonUtil.object2Map(request.jsonData());
        Map<String, Object> res1 = JsonUtil.object2Map(
                ((Map<String, Object>) ((Map<String, Object>) response.get("willingnessPurposeMasterDegree"))
                        .get("pleaseConfirmPurposeChoosingAboveSkillsEducationalInstitutions"))
        );
        Map<String, Object> res2 = JsonUtil.object2Map(
                ((Map<String, Object>) ((Map<String, Object>) response.get("willingnessPurposeMasterDegree"))
                        .get("pleaseConfirmPurposeUseKnowledgeSkillsExperienceAfterGraduationToContributeToDevelopment"))
        );
        String des1 = (String) res1.get("value");
        String des2 = (String) res2.get("value");
        String replaceAllDes1 = des1.replaceAll(" ", "␣");
        String replaceAllDes2 = des2.replaceAll(" ", "␣");

        KhmerLangRequestDto khmerLangRequestDto = new KhmerLangRequestDto(replaceAllDes1, false);
        KhmerLangResponseDto khmerLangResponseDto = this.khmerlangClient.wordSegmentation(khmerLangRequestDto);

        String joinString = String.join("​", khmerLangResponseDto.results());
        String finalResult = joinString.replaceAll("␣", " ");

        log.info("Original Des1 : {} ", des1);
        log.info("Original Des2 : {} ", des2);
        log.info("Replaced Des1 : {} ", replaceAllDes1);
        log.info("Replaced Des2 : {} ", replaceAllDes2);
        log.info("KhmerLangResponseDto 1: {} ", khmerLangResponseDto);
        log.info("Joining String : {} ", joinString);
        log.info("Final Result : {} ", finalResult);*/