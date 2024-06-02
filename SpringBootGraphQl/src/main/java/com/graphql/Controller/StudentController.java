package com.graphql.Controller;

import com.graphql.Entities.Student;
import com.graphql.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id) {
        Integer studentId = Integer.parseInt(id);

        return iStudentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll() {
        return iStudentService.findAll();
    }
}
