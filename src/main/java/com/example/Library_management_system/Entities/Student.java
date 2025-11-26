package com.example.Library_management_system.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //This is the schema of how Student Table will look
@Table
public class Student {

     @Id
     private int studentId;

     private String studentName;

     private  Integer age;

     private String courses;

     private String emailid;

     public String getEmailid() {
          return emailid;
     }

     public void setEmailid(String emailid) {
          this.emailid = emailid;
     }


     public int getStudentId() {
          return studentId;
     }

     public void setStudentId(int studentId) {
          this.studentId = studentId;
     }

     public String getStudentName() {
          return studentName;
     }

     public void setStudentName(String studentName) {
          this.studentName = studentName;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }

     public String getCourses() {
          return courses;
     }

     public void setCourses(String courses) {
          this.courses = courses;
     }


}
