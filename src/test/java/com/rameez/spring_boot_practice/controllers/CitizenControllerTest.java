package com.rameez.spring_boot_practice.controllers;

import com.rameez.spring_boot_practice.dtos.CitizenDto;
import jakarta.validation.Valid;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

// starts spring context
@SpringBootTest
class CitizenControllerTest {

    @Autowired
    private CitizenController citizenController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCitizenById() {
    }

    @Test
    void addCitizen() {
        CitizenDto citizenDto = new CitizenDto();
        citizenDto.setAadharNo("12345");
        citizenDto.setName("Rameez Ahmad");

        ResponseEntity responseEntity = citizenController.addCitizen(citizenDto);

        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    void deleteCitizenById() {
    }

    @Test
    void updateCitizen() {
    }
}