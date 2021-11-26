package com.codeScriptenrollment.school.model;

public class Course {

    private long course_id;
    private String course_teach;
    private String  course_code;
    private String course_description;
    private int course_credit;

    public Course() {
    }

    public Course(long course_id, String course_teach, String course_code, String course_description, int course_credit) {
        this.course_id = course_id;
        this.course_teach = course_teach;
        this.course_code = course_code;
        this.course_description = course_description;
        this.course_credit = course_credit;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_teach(String course_name) {
        this.course_teach = course_name;
    }

    public String getCourse_teach() {
        return course_teach;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public int getCourse_credit() {
        return course_credit;
    }

    public void setCourse_credit(int course_credit) {
        this.course_credit = course_credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_teach + '\'' +
                ", course_code='" + course_code + '\'' +
                ", course_description='" + course_description + '\'' +
                ", course_credit=" + course_credit +
                '}';
    }
}
