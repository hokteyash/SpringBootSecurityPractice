package com.hokte.SpringSecurityPractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentModel {
    private int id;
    private String name;
    private int marks;
}
