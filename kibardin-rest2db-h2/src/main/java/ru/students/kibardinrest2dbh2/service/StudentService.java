package ru.students.kibardinrest2dbh2.service;

import ru.students.kibardinrest2dbh2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudent(int id);
    Student saveStudent (Student student);

    void deleteStudent(int id);
}
