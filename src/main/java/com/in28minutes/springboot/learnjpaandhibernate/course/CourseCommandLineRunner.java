package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private final CourseJpaRepository repository;


    @Autowired
    private  CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS", "in28minutes"));
        repository.save(new Course(2, "Learn DevOps", "in28minutes"));
        repository.save(new Course(3, "Learn Azure", "Marlo Stanfield"));
        repository.save(new Course(4, "Learn Meth", "Avon Barkesdale"));

        repository.deleteById(3L);

        System.out.println(repository.findAllByAuthor("in28minutes"));
        System.out.println(repository.findByName("Learn Meth"));
    }
}
