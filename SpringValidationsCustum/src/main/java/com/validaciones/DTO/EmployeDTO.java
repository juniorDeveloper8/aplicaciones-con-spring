package com.validaciones.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDTO {
// las validaciones se hacen atraves de anotaciones dentro de los dto

    @NotNull //estas son validaciones
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String email;
    @NotBlank
    @NotNull
    private Long phone;
    @NotBlank
    @NotNull
    private byte age;
    @NotNull
    private double height;
    @NotNull
    private boolean married;
    @NotNull
    private LocalDate dateOfBirth;

    private DepartmentDTO departmentDTO;
}
