package ro.fasttrackit.studentsapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ro.fasttrackit.studentsapp.entity.Student;
import ro.fasttrackit.studentsapp.repository.StudentRepository;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsAppApplication.class, args);
	}

	@Bean
	CommandLineRunner atStartup(StudentRepository repository) {
		return args -> {
			repository.saveAll(List.of(
					new Student("Ana", 25),
					new Student("Ioan", 25),
					new Student("George", 45)
			));
		};
	}
}
