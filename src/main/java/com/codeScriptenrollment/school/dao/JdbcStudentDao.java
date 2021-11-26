package com.codeScriptenrollment.school.dao;

import com.codeScriptenrollment.school.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStudentDao implements StudentDao{
    private final JdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(getClass());

    public JdbcStudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql ="SELECT * FROM Students";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Student student = rowMap(result);
            students.add(student);
        }
        return students;
    }

    @Override
    public Student getStudentById(long id) throws SQLException {
        Student student = null;
        String sql =" SELECT * FROM Students WHERE student_id =?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,id);
        if(result.next()){
            student = rowMap(result);
            return student;
        }
        else {
            throw  new SQLException();
        }
    }

    @Override
    public boolean removeStudent(long studentId) {
        String sql ="DELETE FROM Students WHERE student_id =?";
        return jdbcTemplate.update(sql,studentId)==1;
    }

    @Override
    public boolean updateStudentMajor(long studentId, String newMajor) {
        String sql = "UPDATE Students major=? WHERE student_id =?";
        return jdbcTemplate.update(sql,newMajor,studentId)==1;
    }

    @Override
    public boolean enroll(Student newStudent) {
        String sql ="INSERT INTO Students (first_name, last_name, date_of_birth, major) "+
                "VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql,newStudent.getFirst_name(), newStudent.getLast_name(), newStudent.getDate_of_birth(),newStudent.getMajor())==1;
    }

    private Student rowMap(SqlRowSet value){
        Student student = new Student();
        student.setStudent_id(value.getLong("student_id"));
        student.setFirst_name(value.getString("first_name"));
        student.setLast_name(value.getString("last_name"));
        student.setMajor(value.getString("major"));
        student.setDate_of_birth(value.getDate("date_of_birth").toLocalDate());
        return student;
    }
}
