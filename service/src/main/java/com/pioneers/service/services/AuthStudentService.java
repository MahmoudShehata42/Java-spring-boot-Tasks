package com.pioneers.service.services;

import com.pioneers.service.errors.exceptions.*;
import com.pioneers.service.models.dtos.requests.StudentLogin;
import com.pioneers.service.models.dtos.requests.StudentRegister;

import java.util.List;

public interface AuthStudentService {

    void signup(final StudentRegister studentRegisterRequest) throws RegisterException, ValidationException;

    void login(final StudentLogin studentLoginRequest) throws LoginException, CredentialsException;

    void logout(final String email) throws LogoutException;

    Object saveAll(final List<StudentRegister> studentRegisterRequests) throws RegisterException, ValidationException;
}
