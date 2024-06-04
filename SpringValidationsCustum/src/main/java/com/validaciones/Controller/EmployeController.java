package com.validaciones.Controller;

import com.validaciones.DTO.EmployeDTO;
import com.validaciones.Entities.Employes;
import com.validaciones.Service.EmployeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping("/save")
    public ResponseEntity<Employes> saveEmploye(@RequestBody @Valid EmployeDTO employeDTO) {
        return new ResponseEntity<>(this.employeService.saveEmployee(employeDTO), HttpStatus.CREATED);
    }
}
