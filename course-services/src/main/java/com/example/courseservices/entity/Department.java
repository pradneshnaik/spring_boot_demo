package com.example.courseservices.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "department_id")
  private long departmentId;
  private String name;

  @OneToMany(mappedBy = "department")
  private Set<Course> courses;
}
