package com.institute.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.institute.repository.entity.CourseEntity;
import com.institute.repository.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Student {
    private Long id;
    private String lastName;
    private String firstName;
    private List<Course> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public StudentEntity retrieveEntity(){
        StudentEntity entity = new StudentEntity();
        if (this.getId() != null)
            entity.setId(this.getId());
        entity.setFirstName(this.getFirstName());
        entity.setLastName(this.getLastName());
        List<CourseEntity> courseEntities = new ArrayList<>();
        if (this.getCourses() == null)
            return entity;
        this.getCourses().forEach(aCourse -> courseEntities.add(aCourse.retrieveEntity()));
        entity.setCourses(courseEntities);
        return entity;
    }

    public Student retrieveModel(StudentEntity entity){
        if (entity == null)
            return null;
        Student model = new Student();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        List<Course> courses = new ArrayList<>();
        if (entity.getCourses() == null)
            return model;

        entity.getCourses().forEach(aCourse -> courses.add(new Course().retrieveSimpleModel(aCourse)));
        model.setCourses(courses);
        return model;
    }

    public Student retrieveSimpleModel(StudentEntity entity){
        if (entity == null)
            return null;
        Student model = new Student();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        return model;
    }

}
