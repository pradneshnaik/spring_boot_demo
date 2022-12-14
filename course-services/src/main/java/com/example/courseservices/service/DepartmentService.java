package com.example.courseservices.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.courseservices.dto.DepartmentDto;
import com.example.courseservices.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentService {

  private final DepartmentRepository departmentRepository;

  public List<DepartmentDto> getAllDepartment() {
    List<DepartmentDto> departmentDtoList = departmentRepository.findAll().stream().map(
        department -> DepartmentDto.builder().departmentId(department.getDepartmentId()).name(department.getName())
            .build()).collect(
        Collectors.toList());
    return departmentDtoList;
  }

}
