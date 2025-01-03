package sead.assignment2.template.internal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sead.assignment2.template.internal.dto.InternalTemplateDto;
import sead.assignment2.template.internal.dto.SaveTemplateRequestDto;
import sead.assignment2.template.internal.service.InternalTemplateService;

@RestController
@CrossOrigin("*")
@RequestMapping("/template")
class TemplateController {

    @Autowired
    private InternalTemplateService service;

    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok("ok :)");
    }

    @PostMapping
    public ResponseEntity<InternalTemplateDto> createTemplate(@RequestBody SaveTemplateRequestDto dto) {
        return ResponseEntity.ok(service.createTemplate(dto));
    }

    @GetMapping
    public ResponseEntity<Page<InternalTemplateDto>> getTemplates(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(service.getTemplates(page, limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternalTemplateDto>  getTemplateById(@PathVariable Long id){
        return ResponseEntity.ok(service.getTemplateById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternalTemplateDto> updateTemplateById(@PathVariable Long id, @RequestBody SaveTemplateRequestDto dto) {
        return ResponseEntity.ok(service.updateTemplateById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>  deleteTemplateById(@PathVariable Long id) {
        service.deleteTemplateById(id);
        return ResponseEntity.ok(true);
    }
}
