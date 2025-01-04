package sead.assignment2.auth.internal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sead.assignment2.auth.external.JwtService;
import sead.assignment2.auth.internal.dto.AuthDto;
import sead.assignment2.external.dto.ExternalUserDto;
import sead.assignment2.external.service.ExternalUserService;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class AuthService implements InternalAuthService{

    @Autowired
    private ExternalUserService service;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public AuthDto register(String emailAddress, String password) throws Exception {

        String encryptedPassword = passwordEncoder.encode(password);
        ExternalUserDto newUserDto = service.createUser(emailAddress, encryptedPassword);

        return new AuthDto(newUserDto.getId(), newUserDto.getEmailAddress(), newUserDto.getCreatedAt(), newUserDto.getUpdatedAt(), jwtService.generateToken(newUserDto));

    }

    public AuthDto signIn(String email, String password) throws Exception {

        ExternalUserDto userDto = service.getUserByEmailAddress(email);

        if (!passwordEncoder.matches(password, userDto.getPassword())) {
            throw new BadCredentialsException("Invalid password.");
        }

        return new AuthDto(userDto.getId(), userDto.getEmailAddress(), userDto.getCreatedAt(), userDto.getUpdatedAt(), jwtService.generateToken(userDto));
    }
}
