package com.codeScriptenrollment.school.dao;

import com.codeScriptenrollment.school.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    List<Course> list() throws SQLException;
    Course getCourseByCode(String code) throws SQLException;
    Course getCourseByName(String name) throws SQLException;
    boolean create(Course course);
    boolean delete(String code);
}
