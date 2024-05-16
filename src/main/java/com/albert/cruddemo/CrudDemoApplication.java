package com.albert.cruddemo;

import com.albert.cruddemo.dao.StudentDAO;
import com.albert.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            //  readStudents(studentDAO);
            // queryByLastName(studentDAO);
//            updateStudent(studentDAO);
            deleteStudent(studentDAO);

        };
    }


    private void createMultipleStudents(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new 5 student objects ...");
        Student tempStudent1 = new Student("John", "Doe", "johndoe@mail.com");
        Student tempStudent2 = new Student("Alice", "Smith", "alicesmith@mail.com");
        Student tempStudent3 = new Student("John", "Johnson", "johnjohnson@mail.com");
        Student tempStudent4 = new Student("Emma", "Brown", "emmabrown@mail.com");
        Student tempStudent5 = new Student("Michael", "Davis", "michaeldavis@mail.com");


        //save the student object
        System.out.println("Saving the students....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        studentDAO.save(tempStudent4);
        studentDAO.save(tempStudent5);
    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "pauldoe@mail.com");

        //save the student object
        System.out.println("Saving the student....");
        studentDAO.save(tempStudent);

        //display id of the saved student
        System.out.println(STR."Generated ID of the saved Student:\{tempStudent.getId()}");
    }


    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating a new student...");
        Student tempStudent = new Student("Jack", "Harrington", "jackharrington@mail.com");

        // save the student
        System.out.println("Saving student ....");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int studentId = tempStudent.getId();
        System.out.println(STR."Saved student.Generated id :\{studentId}");

        // retrieve student based on the id:primary key
        System.out.println(STR."Retrieving student with id:\{studentId}");
        Student myStudent = studentDAO.findById(studentId);

        // display student
        System.out.println(STR."Found the student: \{myStudent}");

    }

    private void readStudents(StudentDAO studentDAO) {
        // retrieve students
        System.out.println("Retrieving students ....");
        List<Student> students = studentDAO.findAll();

        // display students
        // System.out.println(STR."Students List: \{students}");

        //for loop
        for (Student student : students) {
            System.out.println(student);
        }

    }

    private void queryByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Doe");

        for (Student student : students) {
            System.out.println(student);
        }

    }

    private  void updateStudent(StudentDAO studentDAO){
        int studentId = 2;
        System.out.println("Finding student by id ....");
        Student student = studentDAO.findById(studentId);

        System.out.println("Updating student ....");
        student.setFirstName("John");
        student.setEmail("johndoe@mail.com");

        studentDAO.update(student);

        System.out.println(STR."Displaying updated student \{student}");
    }

    private  void deleteStudent(StudentDAO studentDAO){
        int studentId = 1;

        System.out.println(STR."Deleting student id:\{studentId}");

        studentDAO.delete(studentId);
    }


}
