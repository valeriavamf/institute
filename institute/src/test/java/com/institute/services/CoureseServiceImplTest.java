package com.institute.services;

import com.institute.model.Course;
import com.institute.repository.CourseRepository;
import com.institute.repository.entity.CourseEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

public class CoureseServiceImplTest {

    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CoureseServiceImpl service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createCourse_CheckCourseIsSave() throws Exception {

        Course course = new Course();
        course.setCode("code1");
        course.setDescription("desc");
        course.setTitle("title");

        CourseEntity entity = new CourseEntity();
        entity.setCode("code1");
        entity.setDescription("desc");
        entity.setTitle("title");

        when(courseRepository.save(isA(CourseEntity.class))).thenReturn(entity);

        Course result = service.createCourse(course);

        assertNotNull(result);
        assertEquals(result.getCode(),course.getCode());

    }

    @Test
    public void retrieveAll_CheckCourseAreRetrived() throws Exception {

        Course course = new Course();
        course.setCode("code1");
        course.setDescription("desc");
        course.setTitle("title");

        CourseEntity entity = new CourseEntity();
        entity.setCode("code1");
        entity.setDescription("desc");
        entity.setTitle("title");

        when(courseRepository.findAll()).thenReturn(Arrays.asList(entity));

        List<Course> result = service.retrieveAll();

        assertNotNull(result);
        assertEquals(result.size(),1);

    }

    @Test
    public void retrieveAll_CheckCourseisEmptyWhenThereIsNoData() throws Exception {

        when(courseRepository.findAll()).thenReturn(null);

        List<Course> result = service.retrieveAll();

        assertNotNull(result);
        assertEquals(result.size(),0);

    }

    @Test
    public void deleteCourse_CheckCourseIsDeleted() throws Exception {
        String code = "code";
        CourseEntity entity = new CourseEntity();
        entity.setCode("code1");
        entity.setDescription("desc");
        entity.setTitle("title");

        Optional<CourseEntity> optionalCourse = Optional.of(entity);

        when(courseRepository.findById(code)).thenReturn(optionalCourse);

        String result = service.deleteCourse(code);

        assertNotNull(result);
        assertEquals(result,"course deleted");

    }

    @Test
    public void deleteCourse_CheckCourseIsNotDeleted() throws Exception {
        String code = "code";

        when(courseRepository.findById(code)).thenReturn(null);

        String result = service.deleteCourse(code);

        assertNotNull(result);
        assertEquals(result,"course not founnd");

    }

    @Test
    public void updateCourse_CheckCourseIsSave() throws Exception {

        Course course = new Course();
        course.setCode("code1");
        course.setDescription("desc");
        course.setTitle("title");

        CourseEntity entity = new CourseEntity();
        entity.setCode("code1");
        entity.setDescription("desc2");
        entity.setTitle("title");

        Optional<CourseEntity> optionalCourse = Optional.of(entity);

        when(courseRepository.findById(course.getCode())).thenReturn(optionalCourse);

        when(courseRepository.save(isA(CourseEntity.class))).thenReturn(entity);

        Course result = service.updateCourse(course,course.getCode());

        assertNotNull(result);
        assertEquals(result.getDescription(),course.getDescription());

    }
}