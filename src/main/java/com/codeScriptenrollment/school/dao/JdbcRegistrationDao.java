package com.codeScriptenrollment.school.dao;

import com.codeScriptenrollment.school.model.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcRegistrationDao implements RegistrationDao{

    private final JdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(getClass());

    public JdbcRegistrationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Registration> list() {
        List<Registration> registrations = new ArrayList<>();
        String sql = "SELECT * FROM REGISTRATION";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Registration registration = rowMap(result);
            registrations.add(registration);
        }
        return registrations;
    }

    @Override
    public List<Registration> getRegistrationByStudentId(long studentId) {
        List<Registration> registrationList = new ArrayList<>();
        String sql = "SELECT * FROM REGISTRATION WHERE student_Id=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,studentId);
        while(result.next()){
            Registration registration = rowMap(result);
            registrationList.add(registration);
        }
        return registrationList;
    }

    @Override
    public boolean registry(Registration registration) {
        String sql = "INSERT INTO REGISTRATION (student_id,semester, course_code)"+
                " VALUES(?,?,?)";
        return jdbcTemplate.update(sql,registration.getStudent_id(),registration.getSemester(),registration.getCourse_code())==1;
    }

    @Override
    public boolean drop(long registrationId) {
        String sql ="DELETE FROM REGISTRATION WHERE registration_id=?";
        return jdbcTemplate.update(sql,registrationId)==1;
    }

    @Override
    public Registration getById(long studentId) {
        Registration registration = null;
        String sql ="SELECT * FROM REGISTRATION WHERE student_id=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,studentId);
        while (result.next()){
            registration= rowMap(result);
        }
        return registration;

    }

    private Registration rowMap(SqlRowSet result) {
        Registration registration = new Registration();
        long registrationId = result.getLong("registration_id");
        long studentId = result.getLong("student_id");
        String semester = result.getString("semester");
        String courseCode = result.getString("course_code");
        registration.setStudent_id(studentId);
        registration.setSemester(semester);
        registration.setRegistration_id(registrationId);
        registration.setCourse_code(courseCode);
        return registration;
    }
}
