package org.demo.exo_02.controller;

import org.demo.exo_02.model.Student;
import org.demo.exo_02.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getStudentNames());
        return "studentList";
    }

    @GetMapping("/students/search")
    public String searchStudent(@RequestParam("lastName") String lastName, Model model) {
        List<Student> students = studentService.getStudentsByLastName(lastName);
        model.addAttribute("students", students);
        return "studentSearchResult";
    }
}
