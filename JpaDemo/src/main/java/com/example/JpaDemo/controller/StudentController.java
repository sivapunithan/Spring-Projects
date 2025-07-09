package com.example.JpaDemo.controller;

import com.example.JpaDemo.model.Student;
import com.example.JpaDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    StudentService studentservice;

    @GetMapping("/students")
   public List<Student> getAllStudents(){
        return studentservice.getstudents();
    }
    @PostMapping("/students")
    public String addstudents(@RequestBody Student student){
        studentservice.addStudents(student);
        return "added Succesfully";
    }

    @PostMapping("/students/{rno}")
    public Student getStudentById(@PathVariable int rno){
        return studentservice.getStudentById(rno);
    }
    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student){
        studentservice.updateStudent(student);
        return "updated successfully...";
    }
    @DeleteMapping("/students/{rno}")
    public String deleteStudent(@PathVariable int rno){
        studentservice.deleteStudent(rno);
        return "Deleted Successfully";
    }
    @GetMapping("/students/technology/{technology}")
    public List<Student> getStudentByTechnology(@PathVariable String technology){
        return studentservice.getStudentsByTechnology(technology);
    }
    @PostMapping("/students/filter")
    public List<Student> getStudentByGenderAndTechnology(@Param("gender") String gender,@Param("technology") String technology){
        return studentservice.getStudentByGenderAndTechnology(gender,technology);
    }

}
