package com.codeScriptenrollment.school.dao;

import com.codeScriptenrollment.school.model.Course;
import com.codeScriptenrollment.school.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {

    List<Teacher> getAllTeacher();
    Teacher getTeacherById(long id) throws SQLException;
    boolean removeTeacher(long teacherId);
    boolean updateTeacherDiscipline(long teacherId, Course newDiscipline);
    boolean recruit(Teacher newTeacher);
}
