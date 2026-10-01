package com.pioneers.functionalprogramming.assignment.Rules;

import com.pioneers.functionalprogramming.assignment.Interfaces.IRule;
import com.pioneers.functionalprogramming.assignment.Interfaces.OnFailure;
import org.springframework.stereotype.Component;

@Component
public class NameRule implements IRule<String> {

    @Override
    public void apply(String name, OnFailure onFailure) {
        if (name == null || name.isBlank()) {
            onFailure.execute("Name cannot be empty");

            throw  new IllegalArgumentException("Name cannot be empty");
        }

        if (name.length() < 3 || name.length() > 20) {
            onFailure.execute("Name must be between 3 and 20 characters");
            throw  new IllegalArgumentException("Name must be between 3 and 20 characters");

        }

     }



}
