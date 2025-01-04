package sead.assignment2.auth.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignInRequestDto {

    private String email;

    private String password;
}
