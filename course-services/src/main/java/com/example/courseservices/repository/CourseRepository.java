package com.example.courseservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseservices.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
