package com.example.courseservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseservices.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Department findByDepartmentId(Long departmentId);
}
