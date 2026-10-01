package com.pioneers.functionalprogramming.assignment.Interfaces;

@FunctionalInterface
public interface OnFailure {
    void execute(String message);
}
