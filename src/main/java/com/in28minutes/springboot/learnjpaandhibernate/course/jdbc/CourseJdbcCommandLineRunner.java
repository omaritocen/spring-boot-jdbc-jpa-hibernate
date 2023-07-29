package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository repository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", "in28minutes"));
        repository.insert(new Course(2, "Learn DevOps", "in28minutes"));
        repository.insert(new Course(3, "Learn Azure", "in28minutes"));

        repository.deleteById(2);

        System.out.println(repository.findById(3));
        System.out.println(repository.findById(1));
    }
}
