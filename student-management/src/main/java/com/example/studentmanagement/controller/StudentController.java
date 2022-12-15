package com.example.studentmanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dto.AuthRequest;
import com.example.studentmanagement.dto.StudentRequest;
import com.example.studentmanagement.service.StudentService;

import lombok.AllArgsConstructor;

//RestController is used for making restful web services.
//This annotation is used at the class level and allows the class to handle the requests made by the client.
@RestController
// RequestMapping annotation is used to map web requests onto specific handler classes
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

  private final StudentService studentService;

  @PostMapping("/authenticate")
  public Map<String, String> authenticateUser(@RequestBody AuthRequest authRequest) {
    Map<String, String> resultMap = new HashMap<>();

    String result = "success";
    if (!studentService.isValidUser(authRequest)) {
      result = "Invalid User !!!";
    }
    resultMap.put("result", result);
    return resultMap;
  }


  @PostMapping("/registerStudent")
  public Map<String, String> registerStudent(@RequestBody StudentRequest studentRequest) {
    Map<String, String> resultMap = new HashMap<>();
    String result = studentService.registerStudent(studentRequest);
    resultMap.put("result", result);
    return resultMap;
  }

}
