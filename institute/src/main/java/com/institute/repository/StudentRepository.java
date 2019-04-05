package com.institute.repository;

import com.institute.repository.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository  extends CrudRepository<StudentEntity, Long>,StudentGenericRepository {
    List<StudentEntity> findAll();
}
