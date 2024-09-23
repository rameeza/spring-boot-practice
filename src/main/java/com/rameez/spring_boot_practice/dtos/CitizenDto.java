package com.rameez.spring_boot_practice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenDto {
    @NotNull
    @NotBlank
    private String aadharNo;

    @NotNull
    @NotBlank
    private String name;

}
