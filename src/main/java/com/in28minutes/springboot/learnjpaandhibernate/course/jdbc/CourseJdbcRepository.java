package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private final JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
            """
                   INSERT INTO course (id, name, author)
                   VALUES(?, ?, ?);
            """;

    private static String DELETE_QUERY =
            """
                   DELETE FROM course
                   where id = ?;
            """;

    private static String SELECT_QUERY =
            """
                   SELECT * FROM course
                   where id = ?;
            """;

    public CourseJdbcRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.id(), course.name(), course.author());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new DataClassRowMapper<>(Course.class), id);
    }


}
