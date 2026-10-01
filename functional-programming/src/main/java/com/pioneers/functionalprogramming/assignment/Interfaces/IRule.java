package com.pioneers.functionalprogramming.assignment.Interfaces;

public interface IRule <T>{
    void apply(T  t,OnFailure onFailure);
}
