package com.example.courseservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CourseServicesApplication {

  public static void main(String[] args) {
    SpringApplication.run(CourseServicesApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}
