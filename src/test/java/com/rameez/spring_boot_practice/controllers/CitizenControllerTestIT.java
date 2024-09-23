package com.rameez.spring_boot_practice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rameez.spring_boot_practice.constants.ControllerPath;
import com.rameez.spring_boot_practice.dtos.CitizenDto;
import com.rameez.spring_boot_practice.entities.Citizen;
import com.rameez.spring_boot_practice.mappers.CitizenMapper;
import com.rameez.spring_boot_practice.repositories.CitizenRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// starts spring context
@SpringBootTest
class CitizenControllerTestIT {

    @Autowired
    private CitizenController citizenController;

    @Autowired
    private CitizenRepo citizenRepo;

    private Citizen aValidCitizenEntity;

    @Autowired
    private CitizenMapper citizenMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;


    @Test
    @Transactional
    @Rollback
    void addCitizen() throws Exception {

        CitizenDto citizenDto = CitizenDto.builder()
                .aadharNo("test1")
                .name("Baba")
                .build();

        MvcResult mvcResult = mockMvc.perform(post(ControllerPath.BASE_PATH_CITIZEN + ControllerPath.POST)
                        .content(objectMapper.writeValueAsString(citizenDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.aadharNo", is(citizenDto.getAadharNo())))
                .andReturn();

        System.out.println(mvcResult);

    }

    @Rollback
    @Transactional
    @Test
    void getAllCitizens() throws Exception {

        aValidCitizenEntity = Citizen.builder()
                .aadharNo("adharno123")
                .name("Rameez")
                .build();
        // save a row in db before running any test.
        Citizen savedCitizen = citizenRepo.save(aValidCitizenEntity);


        MvcResult mvcResult = mockMvc.perform(get(ControllerPath.BASE_PATH_CITIZEN + ControllerPath.GET))
                .andExpect(status().isOk()).andReturn();

        System.out.println(mvcResult);
    }

    @Test
    void getCitizenById() {
//        mockMvc.perform(get(ControllerPath.GET_BY_AADHAR_PATH)).andExpect();
    }

    @Test
    void updateCitizen() {
    }

    @Test
    void deleteCitizenById() {
    }

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


}