package sead.assignment2.auth.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {

    private Long id;

    private String emailAddress;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private String accessToken;

}
