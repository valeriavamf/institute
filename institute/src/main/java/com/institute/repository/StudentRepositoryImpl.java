package com.institute.repository;

import com.institute.repository.entity.StudentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentGenericRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<StudentEntity> retrieveStudents(Long id, String firstName, String lastName) {
        List<StudentEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from student where ");

        if (id == null && firstName == null && lastName == null)
            return result;

        if (id != null)
            sql.append("id := id ");

        if (firstName != null)
            sql.append(" and first_name := firstName ");

        if (lastName != null)
            sql.append(" and last_name := lastName ");
        Query query = em.createNativeQuery(sql.toString(), StudentEntity.class);
        return query.getResultList();
    }
}
