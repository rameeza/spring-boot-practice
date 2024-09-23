package com.rameez.spring_boot_practice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Citizen {

    @Id
    @NotNull
    @NotBlank
    private String aadharNo;

    @NotNull
    @NotBlank
    private String name;

}
