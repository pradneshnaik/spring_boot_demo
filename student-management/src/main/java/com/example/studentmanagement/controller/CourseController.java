package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.studentmanagement.dto.CourseDto;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.CourseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
@CrossOrigin
public class CourseController {

  private final CourseService courseService;

  @GetMapping("/list")
  public List<CourseDto> getCoursesByUser(@RequestParam String email) {

    return courseService.findCoursesByUser(email);
  }
}
