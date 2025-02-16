package com.example.JPADemo.service;

import com.example.JPADemo.model.Student;
import com.example.JPADemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public String addStudent(Student student) {
        studentRepo.save(student);// for add the data into database save used
        return "Successfully Added By Me";
    }

    public Student getStudentByRno(int rno) {
        return studentRepo.findById(rno).orElse(new Student());
    }

    public void updateStudent(Student student) {
        studentRepo.save(student);// for update the data into database also save used
    }

    public String deleteStudentByRno(int rno) {
        studentRepo.deleteById(rno);
        return "Deleted Sucessfully";
    }

    public String clearStudents() {
        studentRepo.deleteAll();
        return "entire data's deleted..";
    }
}
