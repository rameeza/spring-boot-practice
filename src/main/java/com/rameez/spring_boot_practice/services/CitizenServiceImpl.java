package com.rameez.spring_boot_practice.services;

import com.rameez.spring_boot_practice.dtos.CitizenDto;
import com.rameez.spring_boot_practice.entities.Citizen;
import com.rameez.spring_boot_practice.exceptions.ResourceNotFoundException;
import com.rameez.spring_boot_practice.mappers.CitizenMapper;
import com.rameez.spring_boot_practice.repositories.CitizenRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

    private final CitizenMapper citizenMapper;

    private final CitizenRepo citizenRepo;

    /**
     * Retrieves a single citizen from the database by their aadhar number.
     *
     * @param aadharNo the aadhar number of the citizen to retrieve
     * @return A CitizenDto object, containing the aadhar number, name and pincode of the retrieved citizen
     * @throws ResourceNotFoundException if the citizen with the given aadhar number does not exist
     */
    @Override
    public CitizenDto getCitizenById(String aadharNo) {

        // Attempt to retrieve the citizen from the database
        Optional<Citizen> savedCitizenOpt = citizenRepo.findById(aadharNo);

        // If the citizen does not exist, throw a ResourceNotFoundException
        if (!savedCitizenOpt.isPresent()) {
            throw new ResourceNotFoundException();
        }

        // Otherwise, map the citizen entity to a CitizenDto object
        Citizen savedCitizen = savedCitizenOpt.get();
        return citizenMapper.fromCitizenEntityToDto(savedCitizen);
    }

    @Override
    public Citizen addCitizen(@Valid CitizenDto citizenDto) {
        Citizen citizen = citizenMapper.fromCitizenDtoToEntity(citizenDto);
        return citizenRepo.save(citizen);
    }

    @Override
    public void deleteCitizenById(String aadharNo) {
        // citizenRepo.deleteById(aadharNo);
//        Optional<Citizen> savedCitizenOpt = citizenRepo.findById(aadharNo);
//
//        // If the citizen does not exist, throw a ResourceNotFoundException
//        if (!savedCitizenOpt.isPresent()) {
//            throw new ResourceNotFoundException();
//        }
//
//        try {
//            Citizen savedCitizen = citizenRepo.getReferenceById(aadharNo);
//            log.info("Saved citizen: " + savedCitizen);
//        } catch (EntityNotFoundException e) {
//            throw new ResourceNotFoundException();
//        }

        boolean entityExists = citizenRepo.existsById(aadharNo);

        if (!entityExists) {

            throw new ResourceNotFoundException();

        }


        // Otherwise, map the citizen entity to a CitizenDto object
        citizenRepo.deleteById(aadharNo);
    }

    @Override
    public CitizenDto updateCitizen(String aadharNo, @Valid CitizenDto citizenDtoParam) {

        try {
            Citizen savedCitizen = citizenRepo.getReferenceById(aadharNo);
            savedCitizen.setName(citizenDtoParam.getName());
            savedCitizen.setPinCode(citizenDtoParam.getPinCode());
            Citizen updatedCitizen = citizenRepo.save(savedCitizen);
            return citizenMapper.fromCitizenEntityToDto(updatedCitizen);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException();
        }


    }

    @Override
    public List<CitizenDto> getAllCitizens() {
        return citizenRepo.findAll()
                .stream()
                .map(citizenMapper::fromCitizenEntityToDto)
                .toList();
    }

}
