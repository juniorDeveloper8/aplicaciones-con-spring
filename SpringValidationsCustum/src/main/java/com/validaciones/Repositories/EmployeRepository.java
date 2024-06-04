package com.validaciones.Repositories;

import com.validaciones.Entities.Employes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends CrudRepository<Employes, Integer> {
}
