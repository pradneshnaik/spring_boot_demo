package com.example.userservices.service;

import org.springframework.stereotype.Service;

import com.example.userservices.dto.AuthRequest;
import com.example.userservices.dto.StudentRequest;
import com.example.userservices.entity.Student;
import com.example.userservices.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public boolean isValidUser(AuthRequest authRequest){
    boolean present = studentRepository.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword())
        .isPresent();
    return present;
  }

  public String registerStudent(StudentRequest studentRequest){
    String result = "User already exists !!!";
    boolean userAlreadyExists = studentRepository.findByEmail(studentRequest.getEmail()).isPresent();

    if(!userAlreadyExists) {
      Student student = Student.builder().firstName(studentRequest.getFirstName())
          .lastName(studentRequest.getLastName())
          .email(studentRequest.getEmail()).password(studentRequest.getPassword())
          .departmentId(studentRequest.getDepartmentId()).build();

      studentRepository.save(student);
      result="success";
    }

    return result;

  }

  public Student findByEmail(String email) {
    return studentRepository.findByEmail(email).orElse(null);
  }

}
