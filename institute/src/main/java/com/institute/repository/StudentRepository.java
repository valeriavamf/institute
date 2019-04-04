package com.institute.repository;

import com.institute.repository.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository<StudentEntity, Long> {
}
