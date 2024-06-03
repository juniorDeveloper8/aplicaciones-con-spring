package com.graphql.Controller;

import com.graphql.Entities.Course;
import com.graphql.Graphql.InputCourse;
import com.graphql.Service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId" ) String id) {
        Integer courseId = Integer.parseInt(id);
        return courseService.findById(courseId);
    }

    @QueryMapping(name = "findAllCourses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @MutationMapping
    public Course createCourse(@Argument InputCourse inputCourse){
        Course course = new Course();

        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());

        courseService.createCourse(course);

        return  course;
    }

    @MutationMapping(name = "deleteCourseById")
    public String deleteById(@Argument(name = "courseId") String id  ){
        courseService.deleteById(Integer.parseInt(id));

        return "el curso" + id + " se elimino correctamen";
    }

}
