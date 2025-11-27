package com.example.Library_management_system.Services;


import com.example.Library_management_system.Entities.Student;
import com.example.Library_management_system.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){

        studentRepository.save(student);
        return "Student has been saved to the DB";

    }
}
