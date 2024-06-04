package com.validaciones.Controller;

import com.validaciones.DTO.DepartmentDTO;
import com.validaciones.Entities.Department;
import com.validaciones.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<Department> saveDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        return  new ResponseEntity<>(this.departmentService.saveDepartment(departmentDTO), HttpStatus.CREATED);
    }

}
