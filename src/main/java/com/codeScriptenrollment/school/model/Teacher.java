package com.codeScriptenrollment.school.model;

public class Teacher {

    private long teacher_id;
    private String first_name;
    private String last_name;
    private String course_teach;
    private String course_code;

    public Teacher() {
    }

    public Teacher(long teacher_id, String first_name, String last_name, String course_teach, String course_code) {
        this.teacher_id = teacher_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.course_teach = course_teach;
        this.course_code = course_code;
    }

    public long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCourse_teach() {
        return course_teach;
    }

    public void setCourse_teach(String course_teach) {
        this.course_teach = course_teach;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_name) {
        this.course_code = course_name;
    }

    @Override
    public String toString() {
        return "Teacher{" +

                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", course_teach='" + course_teach + '\'' +
                ", course_name='" + course_code + '\'' +
                '}';
    }
}
