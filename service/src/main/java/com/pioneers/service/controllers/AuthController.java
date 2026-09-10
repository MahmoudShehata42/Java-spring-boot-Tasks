package com.pioneers.service.controllers;

import com.pioneers.service.errors.exceptions.*;
import com.pioneers.service.models.dtos.requests.StudentLogin;
import com.pioneers.service.models.dtos.requests.StudentRegister;
import com.pioneers.service.models.dtos.responses.GenericResponse;
import com.pioneers.service.services.AuthStudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthStudentService authStudentServiceImpl;

    // TODO: Edit the signup flow to break the flow when the first request validation error happen
    @PostMapping("signup")
    public ResponseEntity<Collection<String>> registerStudentApi(
            @RequestBody final StudentRegister studentRegisterRequest
    ) {
        final String methodName = "registerStudentApi";
        log.info("{}, Implementing Registration flow for [{}]", methodName, studentRegisterRequest.email());

        try {
            authStudentServiceImpl.signup(studentRegisterRequest);
        } catch (final RegisterException e) {
            return ResponseEntity.badRequest().body(List.of(e.getMessage()));
        } catch (final ValidationException e) {
            return ResponseEntity.badRequest().body(e.getErrors());
        }

        log.info("{}, Successfully registered student with email [{}]", methodName, studentRegisterRequest.email());

        return ResponseEntity
                .ok(List.of("Successfully registered student with email: " + studentRegisterRequest.email()));
    }

    @PostMapping("login")
    public ResponseEntity<String> loginApi(@RequestBody StudentLogin studentLoginRequest) {

        try {
            authStudentServiceImpl.login(studentLoginRequest);
        } catch (final LoginException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (final CredentialsException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Passwords don't match");
        }

        return ResponseEntity.ok(
                "Student with email: " + studentLoginRequest.email() + " logged in successfully!!");
    }

    @PostMapping("logout")
    public ResponseEntity<GenericResponse<String>> logoutApi(@RequestParam final String email) {

        try {
            authStudentServiceImpl.logout(email);
        } catch (final LogoutException e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(e.getMessage(), null));
        }

        return ResponseEntity.ok(new GenericResponse<>("Successfully logged out!", null));
    }

    @PostMapping("saveAll")
    public ResponseEntity<?> saveAllApi(@RequestBody List<StudentRegister> studentRegisterRequests) {
        try {
            final Object response = authStudentServiceImpl.saveAll(studentRegisterRequests);

            return ResponseEntity.ok().body(response);
        } catch (RegisterException e) {
            return ResponseEntity.badRequest().body(List.of(e.getMessage()));
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Passwords don't match");
        }
    }
}
