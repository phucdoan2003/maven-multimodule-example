package sead.assignment2.template.internal.service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sead.assignment2.template.external.dto.ExternalTemplateDto;
import sead.assignment2.template.internal.dto.InternalTemplateDto;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Template implements InternalTemplateDto, ExternalTemplateDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;
}
