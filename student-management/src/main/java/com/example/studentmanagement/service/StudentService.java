package com.example.studentmanagement.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.AuthRequest;
import com.example.studentmanagement.dto.StudentRequest;
import com.example.studentmanagement.entity.Department;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.DepartmentRepository;
import com.example.studentmanagement.repository.StudentRepository;

import lombok.AllArgsConstructor;

/* It is used to mark the class as a service provider.
So overall @Service annotation is used with classes that provide some business functionalities. */
@Service
@AllArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
  private final DepartmentRepository departmentRepository;

  public boolean isValidUser(AuthRequest authRequest){
    boolean present = studentRepository.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword())
        .isPresent();
    return present;
  }

  public String registerStudent(StudentRequest studentRequest){
    String result = "User already exists !!!";
    boolean userAlreadyExists = studentRepository.findByEmail(studentRequest.getEmail()).isPresent();

    if(!userAlreadyExists) {

      Department department = departmentRepository.findByDepartmentId(studentRequest.getDepartmentId());

      Student student = Student.builder().firstName(studentRequest.getFirstName())
          .lastName(studentRequest.getLastName())
          .email(studentRequest.getEmail()).password(studentRequest.getPassword())
          .department(department).build();

      studentRepository.save(student);
      result="success";
    }

    return result;

  }

  public Optional<Student> findByEmail(String email) {
    return studentRepository.findByEmail(email);
  }

}
