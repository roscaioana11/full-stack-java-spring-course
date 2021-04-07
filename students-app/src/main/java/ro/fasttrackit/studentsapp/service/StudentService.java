package ro.fasttrackit.studentsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.studentsapp.entity.Student;
import ro.fasttrackit.studentsapp.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Optional<Student> getStudent(long studentId) {
        return repository.findById(studentId);
    }
}
