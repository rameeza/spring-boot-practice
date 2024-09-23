package com.rameez.spring_boot_practice.mappers;

import com.rameez.spring_boot_practice.dtos.CitizenDto;
import com.rameez.spring_boot_practice.entities.Citizen;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class CitizenMapper {
    public CitizenDto fromCitizenEntityToDto(Citizen savedCitizen) {
        CitizenDto citizenDto = new CitizenDto();
        citizenDto.setName(savedCitizen.getName());
        citizenDto.setAadharNo(savedCitizen.getAadharNo());
        return citizenDto;
    }

    public Citizen fromCitizenDtoToEntity(@Valid CitizenDto citizenDto) {
        Citizen citizen = new Citizen();
        citizen.setName(citizenDto.getName());
        citizen.setAadharNo(citizenDto.getAadharNo());
        return citizen;
    }

}
