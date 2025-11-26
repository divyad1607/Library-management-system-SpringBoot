package com.example.Library_management_system.Controllers;

import com.example.Library_management_system.Entities.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class StudentController {

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){

    }
}
