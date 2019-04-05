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
            sql.append(" id=:id and");

        if (firstName != null)
            sql.append(" first_name=:firstName and");

        if (lastName != null)
            sql.append(" last_name=:lastName and");

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

    @Override
    public List<StudentEntity> retrieveStudentsByCourse(String code, String title, String description) {

        List<StudentEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select s.* from course c, student s, course_student cs where " +
                "cs.course_id = c.code and cs.student_id = s.id and");
        if (code == null && title == null && description == null)
            return result;

        if (code != null)
            sql.append(" c.code=:code and");

        if (title != null)
            sql.append(" c.title=:title and");

        if (description != null)
            sql.append(" c.description=:description and");

        int index = sql.lastIndexOf("and");
        sql.replace(index,sql.length(),"");

        Query query = em.createNativeQuery(sql.toString(), StudentEntity.class);

        if (code != null)
            query.setParameter("code",code);

        if (title != null)
            query.setParameter("title",title);

        if (description != null)
            query.setParameter("description",description);


        return query.getResultList();
    }
}
