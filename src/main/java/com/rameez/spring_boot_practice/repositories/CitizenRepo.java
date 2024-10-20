package com.rameez.spring_boot_practice.repositories;

import com.rameez.spring_boot_practice.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitizenRepo extends JpaRepository<Citizen, String> {
    @Query("select c from Citizen c where upper(c.pinCode) = upper(?1) and c.name = ?2")
    List<Citizen> findByPinCodeIgnoreCaseAndName(String pinCode, String name);


}
