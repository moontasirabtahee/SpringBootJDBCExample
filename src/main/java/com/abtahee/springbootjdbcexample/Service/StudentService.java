package com.abtahee.springbootjdbcexample.Service;

import com.abtahee.springbootjdbcexample.Model.Student;
import com.abtahee.springbootjdbcexample.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) {
        studentRepo.create(student);
    }

    public Student getStudentByRoll(int roll) {
        return studentRepo.findByRoll(roll);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void updateStudent(Student student) {
        studentRepo.update(student);
    }

    public void deleteStudent(int roll) {
        studentRepo.delete(roll);
    }
}
