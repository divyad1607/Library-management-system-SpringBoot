package com.example.Library_management_system.Entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //This is the schema of how Student Table will look
@Table(name = "student_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY )
     private Integer rollNo;
     
     @Column(nullable = false)
     private String name;

     private String branch;

     @Column(nullable = false)
     private Double cgpa;

     @Column(unique = true)
     private String emailId;

}
