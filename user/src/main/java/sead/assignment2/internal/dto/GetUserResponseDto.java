package sead.assignment2.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponseDto {
    private String message;

    private InternalUserDto userInfoDTO;
}
