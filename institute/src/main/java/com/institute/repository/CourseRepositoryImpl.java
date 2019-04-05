package com.institute.repository;

import com.institute.repository.entity.CourseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseGenericRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CourseEntity> retrieveCourses(String code, String title, String description) {
        List<CourseEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from student where ");

        if (code == null && title == null && description == null)
            return result;

        if (code != null)
            sql.append("code := code ");

        if (title != null)
            sql.append(" and title := title ");

        if (description != null)
            sql.append(" and description := descriptionn ");
        Query query = em.createNativeQuery(sql.toString(), CourseEntity.class);
        return query.getResultList();
    }
}
