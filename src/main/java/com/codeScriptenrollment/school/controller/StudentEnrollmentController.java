package com.codeScriptenrollment.school.controller;

import com.codeScriptenrollment.school.dao.StudentDao;
import com.codeScriptenrollment.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;


@RestController
@RequestMapping(path = "/codescript.org")
public class StudentEnrollmentController {

    @Autowired
    private final StudentDao studentDao;

    public StudentEnrollmentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @RequestMapping(path = "/student/enrollment",method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentDao.getAllStudent();
    }

    @RequestMapping(path = "/student/enrollment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean removeStudent(@PathVariable long id){
        try{
            studentDao.removeStudent(id);
            return true;
        }catch (ResourceAccessException e){
            e.getStackTrace();
        }catch (RestClientResponseException e){
            e.getMessage();
        }
        return false;
    }

    @RequestMapping(path = "/student/enrollment/{id}",method = RequestMethod.PUT)
    public boolean updateStudentMajor(@PathVariable long id, @RequestBody String major ){
        try{
            studentDao.updateStudentMajor(id,major);
            return true;
        }catch (ResourceAccessException e){
            e.getStackTrace();
        }catch (RestClientResponseException e){
            e.getMessage();
        }
        return false;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/student/enrollment", method = RequestMethod.POST)
    public Student enrollStudent(@RequestBody Student student){
        try{
            studentDao.enroll(student);
            return student;
        }catch (ResourceAccessException e){
            e.getStackTrace();
        }catch (RestClientResponseException e){
            e.getMessage();
            throw new RuntimeException(e);
        }
        return null;
    }
}
