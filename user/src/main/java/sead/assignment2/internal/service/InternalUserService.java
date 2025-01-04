package sead.assignment2.internal.service;



import sead.assignment2.internal.dto.InternalUserDto;

public interface InternalUserService {
    InternalUserDto createUser(String emailAddress, String password) throws Exception;

    InternalUserDto getUserById(Long id) throws Exception;
}
