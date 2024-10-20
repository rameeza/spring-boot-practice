package com.rameez.spring_boot_practice.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void factorialCalc() {

        assertEquals(120, MathUtil.factorialCalc(5));
        assertEquals(3628800, MathUtil.factorialCalc(10));
    }


    @Test
    void testStreamAndLambds() {
        List<String> names = List.of("marsh", "gold", "zaviya", "a", "abu");
        names.stream()
                .filter(s -> (s.length()) % 2 == 1)
                .map(s -> s.toUpperCase())
                .sorted((s1, s2) -> {
                    return s1.length() - s2.length();
                })
                .forEach(x -> System.out.println(x));


    }

    @Test
    void testLoop() {

        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        String output = "";
        for (Integer num : nums) {
            output += nums + " \n";
        }
        System.out.println(output);
    }


}