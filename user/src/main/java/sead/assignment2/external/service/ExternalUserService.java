package sead.assignment2.external.service;



import jakarta.persistence.EntityNotFoundException;
import sead.assignment2.external.dto.ExternalUserDto;
import sead.assignment2.internal.dto.InternalUserDto;

public interface ExternalUserService {
    ExternalUserDto createUser(String emailAddress, String password) throws Exception;

    ExternalUserDto getUserById(Long id) throws Exception;

    ExternalUserDto getUserByEmailAddress(String email) throws EntityNotFoundException;
}
