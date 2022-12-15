package com.example.studentmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.DepartmentDto;
import com.example.studentmanagement.repository.DepartmentRepository;

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
