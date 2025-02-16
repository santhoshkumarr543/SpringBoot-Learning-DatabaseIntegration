package com.example.JPADemo.controller;

import com.example.JPADemo.model.Student;
import com.example.JPADemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{rno}")
    public Student getStudentByRno(@PathVariable int rno)
    {
        return studentService.getStudentByRno(rno);
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "Updated Successfully By Me";
    }

    @DeleteMapping("/students/{rno}")
    public String deleteStudent(@PathVariable int rno){
        return studentService.deleteStudentByRno(rno);
    }

    @DeleteMapping("/students/clear")
    public String clearStudents()
    {
        return studentService.clearStudents();
    }

}
