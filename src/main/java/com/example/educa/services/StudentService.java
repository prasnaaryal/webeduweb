package com.example.educa.services;

import com.example.educa.Entity.Student;
import com.example.educa.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student findByEmail(String email);
    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
