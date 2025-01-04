package sead.assignment2.external.dto;

import org.springframework.security.core.userdetails.UserDetails;
import sead.assignment2.external.enums.AuthRole;

import java.time.LocalDate;

public interface ExternalUserDto extends UserDetails {

    Long getId();

    String getEmailAddress();

    LocalDate getCreatedAt();

    LocalDate getUpdatedAt();

    AuthRole getAuthRole();
}
