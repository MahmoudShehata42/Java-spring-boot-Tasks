package com.pioneers.functionalprogramming.assignment.Rules;

import com.pioneers.functionalprogramming.assignment.Interfaces.IRule;
import com.pioneers.functionalprogramming.assignment.Interfaces.OnFailure;

public class AgeRule implements IRule<Integer> {
    @Override
    public void apply(Integer age, OnFailure onFailure) {
        if (age < 18 || age > 25) {
            onFailure.execute("Age must be between 18 and 25");
            throw  new IllegalArgumentException("Age must be between 18 and 25");
        }
     }
    }

