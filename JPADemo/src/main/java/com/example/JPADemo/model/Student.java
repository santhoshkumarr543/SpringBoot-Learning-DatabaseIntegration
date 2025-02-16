package com.example.JPADemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Student {
    @Id
    private int rno;
    private String gender;
    private String name;
    private String technology;

    public Student() {
    }
}
