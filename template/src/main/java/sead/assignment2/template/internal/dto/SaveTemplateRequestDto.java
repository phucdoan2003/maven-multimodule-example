package sead.assignment2.template.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveTemplateRequestDto {
    private String firstName;
    private String lastName;
}
