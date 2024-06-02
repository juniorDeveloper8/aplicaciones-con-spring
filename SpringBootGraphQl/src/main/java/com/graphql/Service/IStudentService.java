package com.graphql.Service;

import com.graphql.Entities.Student;

import java.util.List;

public interface IStudentService {

    Student findById(Integer id);

    List<Student> findAll();

    void createStudent(Student student);

    void deleteById(Integer id);
}
