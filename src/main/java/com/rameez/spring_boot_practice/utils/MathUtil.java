package com.rameez.spring_boot_practice.utils;

public class MathUtil {
    // method to find factorial of a number
    public static Long factorialCalc(int no) {
        Long factorial = 1L;
        for (int i = 1; i <= no; i++) {
            factorial *= i;
        }
        return factorial;
    }

}
