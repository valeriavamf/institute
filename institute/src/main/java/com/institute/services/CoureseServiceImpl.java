package com.institute.services;

import com.institute.model.Course;
import com.institute.repository.CourseRepository;
import com.institute.repository.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoureseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) throws Exception {
        if (course == null)
            return null;
        if (course.getCode() == null)
            throw new Exception ("code cannot be null");

        CourseEntity entity;
        try {
            entity  = courseRepository.save(course.retrieveEntity());
        }catch (Exception ex){
            throw new Exception("unable to create entity");
        }

        return new Course().retrieveModel(entity);
    }

    @Override
    public List<Course> retrieveAll() {
        List<CourseEntity> allStudents = courseRepository.findAll();
        List<Course> result = new ArrayList<>();
        if (allStudents == null)
            return result;
        allStudents.forEach(entity -> result.add(new Course().retrieveModel(entity)));
        return result;
    }

    @Override
    public Course updateCourse(Course course, String id) throws Exception {
        Optional<CourseEntity> byId = courseRepository.findById(id);
        if (byId == null)
            return null;

        CourseEntity entity = byId.get();
        CourseEntity newEntity = course.retrieveEntity();
        entity.setCode(newEntity.getCode());
        entity.setTitle(newEntity.getTitle());
        entity.setStudents(newEntity.getStudents());
        entity.setDescription(newEntity.getDescription());
        CourseEntity save;
        try{
            save = courseRepository.save(entity);
        }catch (Exception ex){
            throw new Exception("unable to update entity");
        }


        if (save == null)
            return null;
        return new Course().retrieveModel(save);
    }

    @Override
    public String deleteCourse(String studentId) {
        Optional<CourseEntity> byId = courseRepository.findById(studentId);
        if (byId == null)
            return "course not founnd";
        try{
            courseRepository.deleteById(studentId);
        }catch (Exception ex){
            return ex.getMessage();
        }
        return "course deleted";
    }

    @Override
    public List<Course> findCourse( String code, String title, String description) {
        List<Course> result = new ArrayList<>();

        List<CourseEntity> studentEntities = courseRepository.retrieveCourses(code, title, description);

        if (studentEntities == null)
            return result;

        studentEntities.forEach(entity -> result.add(new Course().retrieveModel(entity)));

        return result;
    }

    @Override
    public List<Course> findCourseByStudent(Long id, String lastName, String firstName) {
        List<Course> result = new ArrayList<>();

        List<CourseEntity> studentEntities = courseRepository.retrieveCourseByStudents(id, firstName, lastName);

        if (studentEntities == null)
            return result;

        studentEntities.forEach(entity -> result.add(new Course().retrieveModel(entity)));

        return result;
    }
}
