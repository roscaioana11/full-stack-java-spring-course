package ro.fasttrackit.curs6.students.client;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.curs6.students.client.model.Student;
import ro.fasttrackit.curs6.students.client.service.StudentService;

import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class StudentCommands {
    private final StudentService studentService;

    @ShellMethod("Print all students")
    void printAllStudents() {
        studentService.getAll()
                .forEach(System.out::println);
    }

    @ShellMethod("Get student by id")
    void getStudent() {
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        int lookupId = scanner.nextInt();
        System.out.println(studentService.getById(lookupId));
    }

    @ShellMethod("Add new student")
    void addStudent() {

        System.out.println(studentService.addStudent(new Student(0, "Mihai", 22)));
    }
}
