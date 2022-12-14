package com.example.courseservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  private long studentId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private int departmentId;


}
