package com.example.courseservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseservices.dto.DepartmentDto;
import com.example.courseservices.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
@CrossOrigin
public class DepartmentController {

  private final DepartmentService departmentService;

  @GetMapping("/list")
  public List<DepartmentDto> getAllDepartments() {
    return departmentService.getAllDepartment();
  }

}
