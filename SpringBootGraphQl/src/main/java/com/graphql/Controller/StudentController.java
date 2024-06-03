package com.graphql.Controller;

import com.graphql.Entities.Course;
import com.graphql.Entities.Student;
import com.graphql.Graphql.InputStudent;
import com.graphql.Service.ICourseService;
import com.graphql.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private ICourseService iCourseService;

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id) {
        Integer studentId = Integer.parseInt(id);

        return iStudentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll() {
        return iStudentService.findAll();
    }

    @MutationMapping // se usa la misma notacion de graphql
    public Student createStudent( @Argument InputStudent inputStudent) {
        Student  student =  new Student();
        Course course = iCourseService.findById(Integer.parseInt(inputStudent.getCourseId()));

        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        iStudentService.createStudent(student);

        return student;
    }

    @MutationMapping(name = "deleteStudentById")
    public String deleteById(@Argument(name = "studentId") String id) {

        iStudentService.deleteById(Integer.parseInt(id));

        return "El estudiante se elimino correctamente";
    }

}
