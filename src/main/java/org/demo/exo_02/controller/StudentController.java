package org.demo.exo_02.controller;

import org.demo.exo_02.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
