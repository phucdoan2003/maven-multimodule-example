package sead.assignment2.auth.internal.service;

import sead.assignment2.auth.internal.dto.AuthDto;

public interface InternalAuthService {
    AuthDto register(String emailAddress, String password) throws Exception;

    AuthDto signIn(String email, String password) throws Exception;
}
