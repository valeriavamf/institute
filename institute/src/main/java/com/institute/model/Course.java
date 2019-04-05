package com.institute.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.institute.repository.entity.CourseEntity;
import com.institute.repository.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Course {

    private String code;
    private String title;
    private String description;
    private List<Student> students;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public CourseEntity retrieveEntity(){
        CourseEntity entity = new CourseEntity();
        entity.setCode(this.getCode());
        entity.setDescription(this.getDescription());
        entity.setTitle(this.getTitle());
        List<StudentEntity> studentEntities = new ArrayList<>();
        if (this.getStudents() == null)
            return entity;
        this.getStudents().forEach(aStudent -> studentEntities.add(aStudent.retrieveEntity()));
        entity.setStudents(studentEntities);
        return entity;
    }

    public Course retrieveModel(CourseEntity entity){
        if (entity == null)
            return null;
        Course model = new Course();
        model.setCode(entity.getCode());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        List<Student> students = new ArrayList<>();
        if (entity.getStudents() == null)
            return model;

        entity.getStudents().forEach(aCourse -> students.add(new Student().retrieveSimpleModel(aCourse)));
        model.setStudents(students);
        return model;
    }

    public Course retrieveSimpleModel(CourseEntity entity){
        if (entity == null)
            return null;
        Course model = new Course();
        model.setCode(entity.getCode());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        return model;
    }


}