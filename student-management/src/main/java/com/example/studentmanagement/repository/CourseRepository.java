package com.example.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentmanagement.entity.Course;

/* Annotation is a specialization of @Component annotation which is used to indicate that the class provides
the mechanism for storage, retrieval, update, delete and search operation on objects. */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
