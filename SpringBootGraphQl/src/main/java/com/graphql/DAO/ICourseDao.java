package com.graphql.DAO;

import com.graphql.Entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseDao extends CrudRepository<Course, Integer> {
}
