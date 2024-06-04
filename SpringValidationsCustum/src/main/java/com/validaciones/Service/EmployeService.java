package com.validaciones.Service;

import com.validaciones.DTO.EmployeDTO;
import com.validaciones.Entities.Department;
import com.validaciones.Entities.Employes;
import com.validaciones.Repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public Employes saveEmployee(EmployeDTO employeDTO) {

        Employes employes = Employes.builder()
                .name(employeDTO.getName())
                .lastName(employeDTO.getLastName())
                .phone(employeDTO.getPhone())
                .email(employeDTO.getEmail())
                .dateOfBirth(employeDTO.getDateOfBirth())
                .age(employeDTO.getAge())
                .married(employeDTO.isMarried())
                .height(employeDTO.getHeight())
                .department(Department.builder()
                        .city(employeDTO.getDepartmentDTO().getCity())
                        .name(employeDTO.getDepartmentDTO().getName())
                        .build())
                .build();

        return this.employeRepository.save(employes);
    }
}
