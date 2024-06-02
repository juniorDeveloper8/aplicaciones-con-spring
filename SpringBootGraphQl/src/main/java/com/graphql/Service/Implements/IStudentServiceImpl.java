package com.graphql.Service.Implements;

import com.graphql.DAO.IStudentDao;
import com.graphql.Entities.Student;
import com.graphql.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao iStudentDao;

    @Override
    @Transactional(readOnly = true)
    public Student findById(Integer id) {
        return iStudentDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) iStudentDao.findAll();
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        iStudentDao.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        iStudentDao.deleteById(id);
    }
}
