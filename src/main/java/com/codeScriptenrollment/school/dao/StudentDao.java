package com.codeScriptenrollment.school.dao;

import com.codeScriptenrollment.school.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();
    Student getStudentById(long id) throws SQLException;
    boolean removeStudent(long studentId);
    boolean updateStudentMajor(long studentId, String newMajor);
    boolean enroll(Student newStudent);
}
