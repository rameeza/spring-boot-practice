package com.rameez.spring_boot_practice.services;

import com.rameez.spring_boot_practice.dtos.CitizenDto;
import com.rameez.spring_boot_practice.entities.Citizen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CitizenServiceImplTest {

    @Autowired
    private CitizenService citizenService;

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
        citizenDto.setName("Rameez");

        Citizen savedCitizen = citizenService.addCitizen(citizenDto);
        assertEquals("12345", savedCitizen.getAadharNo());
        assertEquals("Rameez", savedCitizen.getName());
    }

    @Test
    void deleteCitizenById() {
    }

    @Test
    void updateCitizen() {
    }
}