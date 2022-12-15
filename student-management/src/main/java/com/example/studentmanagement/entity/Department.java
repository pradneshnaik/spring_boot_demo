package com.example.studentmanagement.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// defines that a class can be mapped to a table
@Entity
//It specifies the table in the database with which this entity is mapped.
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "department_id")
  private long departmentId;
  private String name;

  @OneToMany(mappedBy = "department")
  private Set<Student> students;

  @OneToMany(mappedBy = "department")
  private Set<Course> courses;
}
