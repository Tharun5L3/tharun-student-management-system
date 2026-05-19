package com.example.studentmanagement.service;



import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Add Student
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Delete Student
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    public Student updateStudent(int id, Student student) {

        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent != null) {

            existingStudent.setName(student.getName());
            existingStudent.setDepartment(student.getDepartment());
            existingStudent.setMarks(student.getMarks());

            return repository.save(existingStudent);
        }

        return null;
    }
}
