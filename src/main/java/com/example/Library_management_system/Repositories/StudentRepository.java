package com.example.Library_management_system.Repositories;

import com.example.Library_management_system.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

   List<Student>findAllByBranchAndCgpaGreaterThan(String branch,double cgpa);

   Student findStudentByEmailId(String emailId);

}
