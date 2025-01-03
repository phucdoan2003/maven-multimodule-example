package sead.assignment2.template.internal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import sead.assignment2.template.external.service.ExternalTemplateService;
import sead.assignment2.template.internal.dto.InternalTemplateDto;
import sead.assignment2.template.internal.dto.SaveTemplateRequestDto;

@Service
class TemplateServiceImpl implements InternalTemplateService, ExternalTemplateService {

    @Autowired
    private TemplateRepository repository;


    @Override
    public InternalTemplateDto createTemplate(SaveTemplateRequestDto dto) {
        return repository.save(new Template(null, dto.getFirstName(), dto.getLastName()));
    }

    @Override
    public Page<InternalTemplateDto> getTemplates(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return repository.findAll(pageable).map(template -> template);
    }

    @Override
    public InternalTemplateDto getTemplateById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Template not found"));
    }

    @Override
    public InternalTemplateDto updateTemplateById(Long id, SaveTemplateRequestDto dto) {
        Template template = repository.findById(id).orElseThrow(() -> new RuntimeException("Template not found"));

        if (dto.getFirstName() != null) {
            template.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null) {
            template.setLastName(dto.getLastName());
        }

        return repository.save(template);
    }

    @Override
    public void deleteTemplateById(Long id) {
        Template template = repository.findById(id).orElseThrow(() -> new RuntimeException("Template not found"));
        repository.delete(template);
    }
}
