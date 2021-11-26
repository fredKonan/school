package com.codeScriptenrollment.school.controller;


import com.codeScriptenrollment.school.dao.TeacherDao;

import com.codeScriptenrollment.school.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path = "/codescript.org")
public class TeacherRecruitmentController {

    @Autowired
    private final TeacherDao teacherDao;

    public TeacherRecruitmentController(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping(path = "/teacher/recruitment",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher recruitTeacher(Teacher newTeacher){
        if(newTeacher!=null){
            teacherDao.recruit(newTeacher);
            return newTeacher;
        }
        return null;
    }
    @RequestMapping(path = "/teacher/recruitment",method = RequestMethod.GET)
    public List<Teacher> getAllTeachers(){
        return teacherDao.getAllTeacher();
    }

    @RequestMapping(path = "/teacher/recruitment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean removeTeacher(@PathVariable long id){
        try{
            teacherDao.removeTeacher(id);
            return true;
        }catch (ResourceAccessException e){
            e.getStackTrace();
        }catch (RestClientResponseException e){
            e.getMessage();
        }
        return false;
    }

    @RequestMapping(path = "/teacher/recruitment/{id}",method = RequestMethod.GET)
    public Teacher getTeacherById(@PathVariable long id) throws SQLException {
        return teacherDao.getTeacherById(id);
    }


}
