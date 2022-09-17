package com.example.basicrudoperation.controller;

import com.example.basicrudoperation.dto.StudentDto;
import com.example.basicrudoperation.model.Student;
import com.example.basicrudoperation.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/getAllStudent")
    public Set<Student> getAllStudent(){
        return service.getAllStudent();
    }

    @PostMapping("/studentDetail")
    public Student studentDetail(@RequestBody StudentDto studentDto){
        return service.studentDetail(studentDto);
    }

    @GetMapping("/getStudentById")
    public Student getStudentById(@RequestParam int stuId){
        return service.getStudentById(stuId);
    }

    @PutMapping("/updateStudentDetailById")
    public Student updateStudentDetailById(@RequestParam int stuId , @RequestParam String name){
        return service.updateStudentDetailById(stuId, name);
    }
}
