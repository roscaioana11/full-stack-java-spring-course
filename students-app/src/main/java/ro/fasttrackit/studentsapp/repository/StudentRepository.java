package ro.fasttrackit.studentsapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.studentsapp.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
