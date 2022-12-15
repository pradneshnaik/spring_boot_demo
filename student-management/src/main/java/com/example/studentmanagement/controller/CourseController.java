package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dto.CourseDto;
import com.example.studentmanagement.service.CourseService;

import lombok.AllArgsConstructor;

//RestController is used for making restful web services.
//This annotation is used at the class level and allows the class to handle the requests made by the client.
@RestController
// RequestMapping annotation is used to map web requests onto specific handler classes
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

  private final CourseService courseService;

  @GetMapping("/list")
  public List<CourseDto> getCoursesByUser(@RequestParam String email) {

    return courseService.findCoursesByUser(email);
  }
}
