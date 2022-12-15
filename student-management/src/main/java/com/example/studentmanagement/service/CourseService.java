package com.example.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.CourseDto;
import com.example.studentmanagement.entity.Department;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.CourseRepository;
import com.example.studentmanagement.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

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
