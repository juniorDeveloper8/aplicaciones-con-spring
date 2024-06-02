package com.graphql.Service;

import com.graphql.Entities.Course;

import java.util.List;

public interface ICourseService {

    Course findById(Integer id);

    List<Course> findAll();

    void createCourse(Course course);

    void deleteById(Integer id);
}
