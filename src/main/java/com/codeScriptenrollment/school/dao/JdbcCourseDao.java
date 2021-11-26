package com.codeScriptenrollment.school.dao;

import com.codeScriptenrollment.school.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCourseDao implements CourseDao {

    private final JdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(getClass());



    public JdbcCourseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Course> list() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM COURSES";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Course course= rowMap(result);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public Course getCourseByCode(String code) throws SQLException {
        Course course = null;
        String sql ="SELECT + FROM COURSES WHERE course_code=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,code);
        if(result.next()){
            course = rowMap(result);
            return course;
        }
        else{
            throw new SQLException();
        }
    }

    @Override
    public Course getCourseByName(String name) throws SQLException {
        Course course = null;
        String sql ="SELECT + FROM COURSES WHERE course_name=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,name);
        if(result.next()){
            course = rowMap(result);
            return course;
        }
        else{
            throw new SQLException();
        }
    }

    @Override
    public boolean create(Course course) {
        if(course!=null){
            String sql="INSERT INTO COURSES (course_teach, course_description,course_code, course_credit)"+
                    " VALUES(?,?,?,?)";
            return jdbcTemplate.update(sql,course.getCourse_teach(),course.getCourse_description(),course.getCourse_code(),course.getCourse_credit())==1;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public boolean delete(String code) {
        String sql ="DELETE FROM COURSES WHERE course_code=?";
        return jdbcTemplate.update(sql,code)==1;
    }

    private Course rowMap(SqlRowSet value){
        Course course = new Course();
        course.setCourse_description(value.getString("course_description"));
        course.setCourse_code(value.getString("course_code"));
        course.setCourse_id(value.getLong("course_id"));
        course.setCourse_teach(value.getString("course_teach"));
        course.setCourse_credit(value.getInt("course_credit"));
        return course;
    }
}
