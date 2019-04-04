package com.institute.repository.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student")
public class StudentEntity {

    @Id
    private long id;
    @Column(name="lastName")
    private String lastName;
    @Column(name="firstName")
    private String firstName;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> subjects;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<CourseEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<CourseEntity> subjects) {
        this.subjects = subjects;
    }
}
