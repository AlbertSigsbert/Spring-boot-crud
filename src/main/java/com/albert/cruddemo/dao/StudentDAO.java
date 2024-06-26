package com.albert.cruddemo.dao;

import com.albert.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List <Student> findByLastName(String lname);

    void update(Student theStudent);

    void delete(Integer id);


}
