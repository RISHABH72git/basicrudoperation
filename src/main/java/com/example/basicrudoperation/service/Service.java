package com.example.basicrudoperation.service;

import com.example.basicrudoperation.dto.StudentDto;
import com.example.basicrudoperation.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@org.springframework.stereotype.Service
public class Service {

    Set<Student> allStudent = new HashSet<>();

    public int gerSeq(){
        return allStudent.size()+1;
    }

    public Set<Student> getAllStudent(){
        return allStudent;
    }

    public Student studentDetail(StudentDto studentDto){
        Student student = new Student();
        student.setStuId(gerSeq());
        student.setFirstName(studentDto.getFirstName());
        student.setSecondName(studentDto.getSecondName());
        student.setCollegeName(studentDto.getCollegeName());
        student.setState(studentDto.getState());
        student.setBranchName(studentDto.getBranchName());
        student.setCity(studentDto.getCity());
        student.setAge(studentDto.getAge());
        allStudent.add(student);
        return student;
    }

    public Student getStudentById(int stuId){
        return allStudent.stream().filter(student -> student.getStuId() == stuId).findAny().get();
    }

    public Student updateStudentDetailById(int stuId , String name){
        Student student = new Student();
        student = allStudent.stream().filter(student1 -> student1.getStuId() == stuId).findAny().get();
        String[] splitName = name.split(" ");
        student.setFirstName(splitName[0]);
        student.setSecondName(splitName[1]);
        allStudent.add(student);
        return student;
    }
}
