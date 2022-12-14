package com.example.courseservices.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.courseservices.dto.CourseDto;
import com.example.courseservices.entity.Course;
import com.example.courseservices.entity.Department;
import com.example.courseservices.repository.CourseRepository;
import com.example.courseservices.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {

  private final CourseRepository courseRepository;
  private final DepartmentRepository departmentRepository;

  public List<CourseDto> getCoursesByDepartment(long departmentId) {
    Department department = departmentRepository.findByDepartmentId(departmentId);
    List<CourseDto> courses = department.getCourses().stream()
        .map(course -> CourseDto.builder().courseId(course.getCourseId()).name(course.getName()).build())
        .collect(Collectors.toList());
    return courses;
  }

}
