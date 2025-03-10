package com.example.SpringJDBC;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.dao.Repo;
import com.example.model.Student;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.dao")
@EntityScan(basePackages = "com.example.model")

public class SpringJdbcApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(SpringJdbcApplication.class, args);
	
	
	//insert the data in the table
	
	Repo repo=context.getBean(Repo.class);
	
	Student s=context.getBean(Student.class); 
	
		
	
	s.setRollNo(106);
	s.setName("Gayathri");
	s.setMarks(1000);
	
	repo.save(s);
	
	
	//FetchAll Data 
	
	System.out.println(repo.findAll());
	
	
	
	//fetch the data By Id
	
	
	System.out.println(repo.findById(106));
	
	
	//anotherway
	
	// Checks if Student ID 105 exists in the database.
	// If found, prints the student details; otherwise, prints a new Student object with default values.

     // Optional<Student>	o=repo.findById(106);
      //System.out.println(o.orElse(new Student()));
	
	

//	System.out.println(repo.findByName("gayu"));
	
	
	//update the data
	

	s.setRollNo(103);
	s.setName("Mehili");
	s.setMarks(1500);
	repo.save(s);
	
	
	//delete the data 
	
	repo.deleteById(105);
	}

}
  