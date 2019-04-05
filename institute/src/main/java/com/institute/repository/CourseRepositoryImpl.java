package com.institute.repository;

import com.institute.repository.entity.CourseEntity;
import com.institute.repository.entity.StudentEntity;
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
        StringBuilder sql = new StringBuilder("select * from course where");

        if (code == null && title == null && description == null)
            return result;

        if (code != null)
            sql.append(" code=:code and");

        if (title != null)
            sql.append(" title=:title and");

        if (description != null)
            sql.append(" description=:description and");

        int index = sql.lastIndexOf("and");
        sql.replace(index,sql.length(),"");

        Query query = em.createNativeQuery(sql.toString(), CourseEntity.class);

        if (code != null)
            query.setParameter("code",code);

        if (title != null)
            query.setParameter("title",title);

        if (description != null)
            query.setParameter("description",description);


        return query.getResultList();
    }

    @Override
    public List<CourseEntity> retrieveCourseByStudents(Long id, String firstName, String lastName) {
        List<CourseEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select c.* from course c, student s, course_student cs where " +
                "cs.course_id = c.code and s.id = cs.student_id and");

        if (id == null && firstName == null && lastName == null)
            return result;

        if (id != null)
            sql.append(" s.id=:id and");

        if (firstName != null)
            sql.append(" s.first_name=:firstName and");

        if (lastName != null)
            sql.append(" s.last_name=:lastName and");

        int index = sql.lastIndexOf("and");
        sql.replace(index,sql.length(),"");

        Query query = em.createNativeQuery(sql.toString(), StudentEntity.class);

        if (id != null)
            query.setParameter("id",id);

        if (firstName != null)
            query.setParameter("firstName",firstName);

        if (lastName != null)
            query.setParameter("lastName",lastName);
        return query.getResultList();
    }
}
