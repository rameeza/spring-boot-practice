package com.rameez.spring_boot_practice.services;

import com.rameez.spring_boot_practice.dtos.CitizenDto;
import com.rameez.spring_boot_practice.entities.Citizen;
import jakarta.validation.Valid;

import java.util.List;

public interface CitizenService {
    CitizenDto getCitizenById(String aadharNumber);

    Citizen addCitizen(@Valid CitizenDto citizen);

    void deleteCitizenById(String aadharNo);

    CitizenDto updateCitizen(@Valid CitizenDto citizen);

    List<CitizenDto> getAllCitizens();
}
