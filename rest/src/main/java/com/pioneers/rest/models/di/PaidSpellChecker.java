package com.pioneers.rest.models.di;

import org.springframework.stereotype.Component;

@Component
public class PaidSpellChecker implements SpellChecker {

    private final String owner = "Tech Pioneers Hub";

    public PaidSpellChecker() {
        System.out.println("I am in the empty constructor of PaidSpellChecker");
    }

    public String getOwner() {
        return owner;
    }
}
