package com.validaciones.Service;

import com.validaciones.DTO.DepartmentDTO;
import com.validaciones.Entities.Department;
import com.validaciones.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(DepartmentDTO departmentDTO) {
        Department department = Department.builder()
                .name(departmentDTO.getName())
                .city(departmentDTO.getCity())
                .build();

        return this.departmentRepository.save(department);
    }
}
