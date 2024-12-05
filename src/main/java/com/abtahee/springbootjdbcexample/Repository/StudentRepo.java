package com.abtahee.springbootjdbcexample.Repository;

import com.abtahee.springbootjdbcexample.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<Student> studentRowMapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student(
                    rs.getString("name"),
                    rs.getInt("roll"),
                    rs.getDouble("marks")
            );
        }
    };

    public void create(Student student) {
        String sql = "INSERT INTO student (name, roll, marks) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getRoll(), student.getMarks());
    }

    public Student findByRoll(int roll) {
        String sql = "SELECT * FROM student WHERE roll = ?";
        return jdbcTemplate.queryForObject(sql, studentRowMapper, roll);
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, studentRowMapper);
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, marks = ? WHERE roll = ?";
        jdbcTemplate.update(sql, student.getName(), student.getMarks(), student.getRoll());
    }

    public void delete(int roll) {
        String sql = "DELETE FROM student WHERE roll = ?";
        jdbcTemplate.update(sql, roll);
    }
}
