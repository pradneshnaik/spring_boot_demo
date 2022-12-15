package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dto.DepartmentDto;
import com.example.studentmanagement.service.DepartmentService;

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
