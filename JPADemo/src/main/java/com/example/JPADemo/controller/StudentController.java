package com.example.JPADemo.controller;

import com.example.JPADemo.model.Student;
import com.example.JPADemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> getStudentByRno(@PathVariable int rno)
    {
        Student student = studentService.getStudentByRno(rno);

        if(student == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(student, HttpStatus.OK);
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

    @GetMapping("/students/technology/{technology}")
    public List<Student> getByTechnology(@PathVariable String technology)
    {
        return studentService.getByTechnology(technology);
    }

    @PostMapping("/students/filter")
    public List<Student> getByGenderandTechnology(@Param("gender") String gender,
                                                  @Param("technology") String technology)
    {
        return studentService.getByGenderAndTechnology(gender,technology);
    }
}
