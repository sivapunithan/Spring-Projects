package com.example.JpaDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class Student {
    @Id
    private int rno;
    private String name;
    private String gender;
    private String technology;
}
