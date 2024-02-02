package com.arithmetic.multiply;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MultiplyBLogic {
    public int execute(int a, int b) {
        System.out.println(" AdditionBLogic.execute(" + a + "," + b + ")");
        return a * b;
    }
}
