package org.demo.exo_02.service;

import org.demo.exo_02.model.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return Arrays.asList(
                new Student("John", "Doe", 25, "john.doe@gmail.com"),
                new Student("Jane", "Doe", 22, "jane.doe@gmail.com"),
                new Student("Alice", "Smith", 30, "alice.smith@gmail.com")
        );
    }

    public List<String> getStudentNames() {
        return getStudents().stream()
                .map(student -> student.getFirstName() + " " + student.getLastName())
                .collect(Collectors.toList());
    }
}