package ro.fasttrackit.curs6.students.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.curs6.students.client.model.Student;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class StudentService {
    public List<Student> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/students",
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Student>>() {
                }
        ).getBody();
    }

    public Student getById(int studentId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/students/" + studentId, Student.class);
    }

    public Student addStudent(Student newStudent) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://localhost:8080/students", newStudent, Student.class);
    }
}
