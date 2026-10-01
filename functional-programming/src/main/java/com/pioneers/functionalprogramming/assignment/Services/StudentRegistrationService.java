package com.pioneers.functionalprogramming.assignment.Services;

import com.pioneers.functionalprogramming.assignment.Interfaces.IRule;
import com.pioneers.functionalprogramming.assignment.Interfaces.OnFailure;
import com.pioneers.functionalprogramming.assignment.Interfaces.OnSuccess;
import com.pioneers.functionalprogramming.assignment.models.DTOs.StudentRegister;
import com.pioneers.functionalprogramming.utils.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class StudentRegistrationService {
    private List<IRule>RULES  ;



    public void register(
            StudentRegister studentRegister,
            OnSuccess onSuccess,
            OnFailure onFailure
    ) {
        RULES.forEach(element->element.apply(studentRegister, onFailure));



        onSuccess.execute();
    }


}
