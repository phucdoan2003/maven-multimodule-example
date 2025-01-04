package sead.assignment2.auth.external;

import org.springframework.security.core.userdetails.UserDetails;
import sead.assignment2.external.dto.ExternalUserDto;
import sead.assignment2.external.enums.AuthRole;

public interface JwtService {
    Boolean isValid(String token, UserDetails user);

    String generateToken(ExternalUserDto dto);

    String getUserIdFromJwt(String token);

    AuthRole getAuthRoleFromJwt(String token);

    Boolean isTokenExpired(String token);
}
