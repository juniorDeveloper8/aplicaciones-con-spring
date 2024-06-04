package com.validaciones.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    @Size(min = 3, max = 10)
    private String lastName;

    @NotNull
    @NotBlank
    @Email
    private String email;

    private Long phone;

    @Min(18)
    @Max(25)
    private byte age;

    @Digits(integer = 2, fraction = 3)
    private double height;
    @AssertFalse
    private boolean married;

    private LocalDate dateOfBirth;
    @Valid
    private DepartmentDTO departmentDTO;
}
