package com.graphql.Service.Implements;

import com.graphql.DAO.ICourseDao;
import com.graphql.Entities.Course;
import com.graphql.Service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ICourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseDao iCourseDao;

    @Override
    @Transactional(readOnly = true)
    public Course findById(Integer id) {
        return iCourseDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) iCourseDao.findAll();
    }

    @Override
    @Transactional
    public void createCourse(Course course) {
        iCourseDao.save(course);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        iCourseDao.deleteById(id);
    }
}
