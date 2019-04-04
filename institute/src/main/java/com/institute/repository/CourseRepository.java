package com.institute.repository;

import com.institute.repository.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository  extends CrudRepository<CourseEntity, String> {
}
