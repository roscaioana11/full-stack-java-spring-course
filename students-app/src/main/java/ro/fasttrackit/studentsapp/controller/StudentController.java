package ro.fasttrackit.studentsapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.studentsapp.entity.Student;
import ro.fasttrackit.studentsapp.exceptions.ResourceNotFoundException;
import ro.fasttrackit.studentsapp.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    List<Student> getStudents() {
        return service.getAll();
    }

    @GetMapping("{studentId}")
    Student getStudent(@PathVariable int studentId) {
        return service.getStudent(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find student with id " + studentId));
    }
}

