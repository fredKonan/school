package com.codeScriptenrollment.school.dao;

import com.codeScriptenrollment.school.model.Registration;

import java.util.List;

public interface RegistrationDao {

    List<Registration> list();
    List<Registration> getRegistrationByStudentId(long studentId);
    boolean registry(Registration registration);
    boolean drop(long registrationId);
    Registration getById(long registrationId);
}
