package com.rameez.spring_boot_practice.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}