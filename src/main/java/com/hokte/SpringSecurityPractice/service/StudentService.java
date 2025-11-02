package com.hokte.SpringSecurityPractice.service;

import com.hokte.SpringSecurityPractice.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public static List<StudentModel> students = new ArrayList<>(List.of(new StudentModel(1,"Yash",95), new StudentModel(2,"Jay",80), new StudentModel(3,"Kev",97)));
    public List<StudentModel> getStudents() {
        return students;
    }
    public StudentModel addStudent(StudentModel student) {
        students.add(student);
        return student;
    }
}
