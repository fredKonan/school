package com.codeScriptenrollment.school.dao;

import com.codeScriptenrollment.school.model.Course;
import com.codeScriptenrollment.school.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTeacherDao implements TeacherDao{

    private final JdbcTemplate jdbcTemplate;
    Logger log = LoggerFactory.getLogger(getClass());

    public JdbcTeacherDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM teachers";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Teacher teacher = rowMap(result);
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public Teacher getTeacherById(long id) throws SQLException {
        Teacher teacher = null;
        String sql ="SELECT * FROM teachers WHERE teacher_id=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,id);
        if(result.next()){
            teacher=rowMap(result);
            return teacher;
        }
        else {
            throw  new SQLException();
        }
    }

    @Override
    public boolean removeTeacher(long teacherId) {
        String sql = "DELETE FROM teachers WHERE teacher_id =?";
        return jdbcTemplate.update(sql,teacherId)==1;
    }

    @Override
    public boolean updateTeacherDiscipline(long teacherId, Course newDiscipline) {
        String sql ="UPDATE teachers course_teach=? AND course_code=? WHERE teacher_id=?";
        return jdbcTemplate.update(sql,newDiscipline.getCourse_teach(), newDiscipline.getCourse_code(),teacherId)==1;
    }

    @Override
    public boolean recruit(Teacher newTeacher) {
        String sql= "INSERT INTO teachers (first_name, last_name, course_teach, course_code) "+
                "VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql,newTeacher.getFirst_name(),newTeacher.getLast_name(),newTeacher.getCourse_teach(),newTeacher.getCourse_code())==1;
    }

    private Teacher rowMap(SqlRowSet value){
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(value.getLong("teacher_id"));
        teacher.setFirst_name(value.getString("first_name"));
        teacher.setLast_name(value.getString("last_name"));
        teacher.setCourse_teach(value.getString("course_teach"));
        teacher.setCourse_code(value.getString("course_code"));
        return teacher;
    }
}
