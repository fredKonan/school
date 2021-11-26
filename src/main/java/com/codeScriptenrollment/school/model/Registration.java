package com.codeScriptenrollment.school.model;

public class Registration {

    private long student_id;
    private long registration_id;
    private String semester;
    private String course_code;

    public Registration() {
    }

    public Registration(long student_id, long registration_id, String semester, String course_code) {
        this.student_id = student_id;
        this.registration_id = registration_id;
        this.semester = semester;
        this.course_code = course_code;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(long registration_id) {
        this.registration_id = registration_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "student_id=" + student_id +
                ", registration_id=" + registration_id +
                ", semester='" + semester + '\'' +
                ", course_code='" + course_code + '\'' +
                '}';
    }
}
