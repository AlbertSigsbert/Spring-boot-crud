package com.albert.cruddemo.dao;

import com.albert.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define fields for entity manager
    private final EntityManager entityManager;

    //inject entity manager using constructor

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery <Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
         return  theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String lname) {
        TypedQuery <Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:last_name", Student.class);
        theQuery.setParameter("last_name", lname);
        return  theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }


}
