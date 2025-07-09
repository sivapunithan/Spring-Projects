package com.example.JpaDemo.service;

import com.example.JpaDemo.model.Student;
import com.example.JpaDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentrepo;
    public List<Student> getstudents() {
        return studentrepo.findAll();
    }

    public String addStudents(Student student) {
        studentrepo.save(student);
        return "Added successfully....";
    }

    public Student getStudentById(int rno) {
       return studentrepo.findById(rno).orElse(new Student());
    }


    public void updateStudent(Student student) {
        studentrepo.save(student);
    }

    public void deleteStudent(int rno) {
        studentrepo.deleteById(rno);
    }

    public List<Student> getStudentsByTechnology(String technology) {
        return studentrepo.findByTechnology(technology);
    }

    public List<Student> getStudentByGenderAndTechnology(String gender, String technology) {
        return studentrepo.findByGenderAndTechnology(gender, technology);
    }
}
