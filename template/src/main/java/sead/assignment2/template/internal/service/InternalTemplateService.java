package sead.assignment2.template.internal.service;

import org.springframework.data.domain.Page;
import sead.assignment2.template.internal.dto.InternalTemplateDto;
import sead.assignment2.template.internal.dto.SaveTemplateRequestDto;

public interface InternalTemplateService {
    InternalTemplateDto createTemplate(SaveTemplateRequestDto dto);
    Page<InternalTemplateDto> getTemplates(int page, int limit);
    InternalTemplateDto getTemplateById(Long id);
    InternalTemplateDto updateTemplateById(Long id, SaveTemplateRequestDto dto);
    void deleteTemplateById(Long id);
}
