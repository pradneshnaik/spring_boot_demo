package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dto.DepartmentDto;
import com.example.studentmanagement.service.DepartmentService;

import lombok.AllArgsConstructor;

//RestController is used for making restful web services.
//This annotation is used at the class level and allows the class to handle the requests made by the client.
@RestController
// RequestMapping annotation is used to map web requests onto specific handler classes
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {

  private final DepartmentService departmentService;

  @GetMapping("/list")
  public List<DepartmentDto> getAllDepartments() {
    return departmentService.getAllDepartment();
  }

}
