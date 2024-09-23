package com.rameez.spring_boot_practice.controllers;


import com.rameez.spring_boot_practice.constants.ControllerPath;
import com.rameez.spring_boot_practice.dtos.CitizenDto;
import com.rameez.spring_boot_practice.entities.Citizen;
import com.rameez.spring_boot_practice.services.CitizenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ControllerPath.BASE_PATH_CITIZEN)
public class CitizenController {

    private final CitizenService citizenService;

    @GetMapping(ControllerPath.GET_BY_AADHAR_PATH)
    public CitizenDto getCitizenById(@PathVariable("aadharNo") String aadharNo) {
        return citizenService.getCitizenById(aadharNo);
    }

    @GetMapping(ControllerPath.GET)
    public List<CitizenDto> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @PostMapping(ControllerPath.POST)
    public ResponseEntity addCitizen(@RequestBody @Valid CitizenDto citizenDto) {
        Citizen savedCitizen = citizenService.addCitizen(citizenDto);
//        return new ResponseEntity(HttpStatus.CREATED);
        URI uri = URI.create(ControllerPath.BASE_PATH_CITIZEN + ControllerPath.GET + "/" + savedCitizen.getAadharNo());
        return ResponseEntity.created(uri).body(savedCitizen);
    }


    @DeleteMapping(ControllerPath.DELETE_BY_AADHAR_PATH)
    public ResponseEntity deleteCitizenById(@PathVariable String aadharNo) {
        citizenService.deleteCitizenById(aadharNo);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(ControllerPath.PUT)
    public ResponseEntity<CitizenDto> updateCitizen(@RequestBody @Valid CitizenDto citizenDto) {
        return new ResponseEntity<>(citizenDto, HttpStatus.CREATED);
    }
}
