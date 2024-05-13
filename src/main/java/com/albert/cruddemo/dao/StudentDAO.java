package com.albert.cruddemo.dao;

import com.albert.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
