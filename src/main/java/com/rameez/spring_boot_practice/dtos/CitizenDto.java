package com.rameez.spring_boot_practice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid Pincode")
    private String pinCode;

}
