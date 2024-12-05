package com.abtahee.springbootjdbcexample;

import com.abtahee.springbootjdbcexample.Model.Student;
import com.abtahee.springbootjdbcexample.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcExampleApplication {

    public static void main(String[] args) {

        ApplicationContext context =  SpringApplication.run(SpringBootJdbcExampleApplication.class, args);

        Student S = context.getBean(Student.class);
        S.setName("Abtahee");
        S.setRoll(12660);
        S.setMarks(89.58);

        StudentService studentService = context.getBean(StudentService.class);
        studentService.addStudent(S);

        System.out.println(studentService.getAllStudents());


        System.out.println(studentService.getStudentByRoll(12660));







    }

}
