package sead.assignment2.internal.dto;

import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;

public interface InternalUserDto extends UserDetails {

    Long getId();

    String getEmailAddress();

    LocalDate getCreatedAt();

    LocalDate getUpdatedAt();

}
