package com.rameez.spring_boot_practice.controllers;


import com.rameez.spring_boot_practice.constants.ControllerPath;
import com.rameez.spring_boot_practice.dtos.CitizenDto;
import com.rameez.spring_boot_practice.entities.Citizen;
import com.rameez.spring_boot_practice.services.CitizenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(ControllerPath.BASE_PATH_CITIZEN)
public class CitizenController {

    private final CitizenService citizenService;

    /**
     * Retrieves a single citizen by their aadhar number from the database
     *
     * @param aadharNo the aadhar number of the citizen to retrieve
     * @return A CitizenDto object, containing the aadhar number, name and pincode of the retrieved citizen
     */
    @GetMapping(ControllerPath.GET_BY_AADHAR_PATH)
    public CitizenDto getCitizenById(@PathVariable("aadharNo") String aadharNo) {
        return citizenService.getCitizenById(aadharNo);
    }

    /**
     * Retrieves a list of all citizens in the database
     *
     * @return A list of CitizenDto objects, each containing the aadhar number, name and pincode of a citizen
     */
    @GetMapping(ControllerPath.GET)
    public List<CitizenDto> getAllCitizens() {
        log.info("Inside Controller: getAllCitizens");
        return citizenService.getAllCitizens();
    }

    /**
     * Creates a new citizen in the database
     *
     * @param citizenDto A CitizenDto object, containing the aadhar number, name and pincode of the citizen to create
     * @return A ResponseEntity containing the newly created citizen, along with a URI pointing to the new citizen
     */
    @PostMapping(ControllerPath.POST)
    public ResponseEntity<Object> addCitizen(@RequestBody @Valid CitizenDto citizenDto) {
        Citizen savedCitizen = citizenService.addCitizen(citizenDto);
//        return new ResponseEntity(HttpStatus.CREATED);
        URI uri = URI.create(ControllerPath.BASE_PATH_CITIZEN + ControllerPath.GET + "/" + savedCitizen.getAadharNo());
        return ResponseEntity.created(uri).body(savedCitizen);
    }


    /**
     * Deletes a citizen from the database by their aadhar number
     *
     * @param aadharNo the aadhar number of the citizen to delete
     * @return A 204 No Content response if the citizen is deleted successfully
     */
    @DeleteMapping(ControllerPath.DELETE_BY_AADHAR_PATH)
    public ResponseEntity<Object> deleteCitizenById(@PathVariable String aadharNo) {
        citizenService.deleteCitizenById(aadharNo);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * Updates a citizen in the database
     *
     * @param aadharNo   the aadhar number of the citizen to update
     * @param citizenDto the updated citizen data
     * @return The updated CitizenDto object, containing the aadhar number, name and pincode of the updated citizen
     */
    @PutMapping(ControllerPath.PUT_BY_AADHAR_PATH)
    public ResponseEntity<CitizenDto> updateCitizen(@PathVariable String aadharNo, @RequestBody @Valid CitizenDto citizenDto) {
        citizenService.updateCitizen(aadharNo, citizenDto);

        return new ResponseEntity<>(citizenDto, HttpStatus.OK);
    }
}
