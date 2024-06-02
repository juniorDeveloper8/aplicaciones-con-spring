package com.graphql.DAO;

import com.graphql.Entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentDao extends CrudRepository<Student, Integer> {
}
