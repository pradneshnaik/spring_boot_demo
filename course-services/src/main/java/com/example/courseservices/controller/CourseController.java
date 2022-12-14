package com.example.courseservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.courseservices.dto.CourseDto;
import com.example.courseservices.entity.Student;
import com.example.courseservices.service.CourseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
@CrossOrigin
public class CourseController {

  private final CourseService courseService;
  private final RestTemplate restTemplate;

  @GetMapping("/list")
  public List<CourseDto> getCoursesByUser(@RequestParam String email) {

    Student student = restTemplate.getForObject("http://user-services/student/" + email, Student.class);
    return courseService.getCoursesByDepartment(student.getDepartmentId());
  }
}
