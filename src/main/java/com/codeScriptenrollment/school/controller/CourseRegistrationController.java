package com.codeScriptenrollment.school.controller;


import com.codeScriptenrollment.school.dao.CourseDao;
import com.codeScriptenrollment.school.dao.RegistrationDao;
import com.codeScriptenrollment.school.dao.StudentDao;
import com.codeScriptenrollment.school.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;

@RestController
@RequestMapping(path = "/codescript.org")
public class CourseRegistrationController {

    private final StudentDao studentDao;
    private final RegistrationDao registrationDao;
    private final CourseDao courseDao;

    @Autowired
    public CourseRegistrationController(StudentDao studentDao, RegistrationDao registrationDao, CourseDao courseDao) {
        this.studentDao = studentDao;
        this.registrationDao = registrationDao;
        this.courseDao = courseDao;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/student/course/registry",method = RequestMethod.POST)
    public Registration registry(@RequestBody Registration registration){
        try{
           registrationDao.registry(registration);
           return registration;

        }catch (ResourceAccessException e){
            e.getStackTrace();
        }catch (RestClientResponseException e){
            e.getMessage();
        }
        return null;
    }

    @RequestMapping(path = "/student/course/registry/{id}",method = RequestMethod.GET)
    public Registration getByStudentId(@PathVariable long id){
        return registrationDao.getById(id);
    }

    @RequestMapping(path ="/student/course/registry",method = RequestMethod.GET)
    public List<Registration> getAlRegistration(){
        return registrationDao.list();
    }

}
