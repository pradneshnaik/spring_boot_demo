package com.example.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.CourseDto;
import com.example.studentmanagement.entity.Student;

import lombok.AllArgsConstructor;

/* It is used to mark the class as a service provider.
So overall @Service annotation is used with classes that provide some business functionalities. */
@Service
@AllArgsConstructor
public class CourseService {

  private final StudentService studentService;

  public List<CourseDto> findCoursesByUser(String email) {

    Optional<Student> student = studentService.findByEmail(email);

    List<CourseDto> courses = new ArrayList<>();
    if (student.isPresent()) {
      courses = student.get().getDepartment().getCourses().stream()
          .map(course -> CourseDto.builder().courseId(course.getCourseId()).name(course.getName()).build())
          .collect(Collectors.toList());
    }
    return courses;
  }

}
