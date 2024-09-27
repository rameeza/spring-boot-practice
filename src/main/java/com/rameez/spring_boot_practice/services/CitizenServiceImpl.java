package com.rameez.spring_boot_practice.services;

import com.rameez.spring_boot_practice.dtos.CitizenDto;
import com.rameez.spring_boot_practice.entities.Citizen;
import com.rameez.spring_boot_practice.mappers.CitizenMapper;
import com.rameez.spring_boot_practice.repositories.CitizenRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

    private final CitizenMapper citizenMapper;

    private final CitizenRepo citizenRepo;

    @Override
    public CitizenDto getCitizenById(String aadharNo) {
        Citizen savedCitizen = citizenRepo.getReferenceById(aadharNo);
        return citizenMapper.fromCitizenEntityToDto(savedCitizen);
    }

    @Override
    public Citizen addCitizen(@Valid CitizenDto citizenDto) {
        Citizen citizen = citizenMapper.fromCitizenDtoToEntity(citizenDto);
        return citizenRepo.save(citizen);
    }

    @Override
    public void deleteCitizenById(String aadharNo) {
        citizenRepo.deleteById(aadharNo);

    }

    @Override
    public CitizenDto updateCitizen(String aadharNo, @Valid CitizenDto citizenDtoParam) {
        Citizen savedCitizen = citizenRepo.getReferenceById(aadharNo);

        savedCitizen.setName(citizenDtoParam.getName());
        savedCitizen.setPinCode(citizenDtoParam.getPinCode());
        Citizen updatedCitizen = citizenRepo.save(savedCitizen);

        return citizenMapper.fromCitizenEntityToDto(updatedCitizen);
    }

    @Override
    public List<CitizenDto> getAllCitizens() {
        return citizenRepo.findAll()
                .stream()
                .map(citizenMapper::fromCitizenEntityToDto)
                .toList();
    }

}
