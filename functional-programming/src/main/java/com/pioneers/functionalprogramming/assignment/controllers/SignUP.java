package com.pioneers.functionalprogramming.assignment.controllers;

import com.pioneers.functionalprogramming.assignment.Services.StudentRegistrationService;
import com.pioneers.functionalprogramming.assignment.models.DTOs.StudentRegister;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class SignUP {
  private final   StudentRegistrationService  studentRegistrationService;

//    @PostMapping("signup")
//    public String registerStudentApi(
//            @RequestBody final StudentRegister studentRegisterRequest
//    ) {
//
//    }

}
