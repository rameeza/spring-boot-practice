package com.rameez.spring_boot_practice.repositories;

import com.rameez.spring_boot_practice.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepo extends JpaRepository<Citizen, String> {
}
