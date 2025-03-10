package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Student;


@Repository
public interface Repo extends JpaRepository<Student, Integer>{
	@Query("select s from Student s where s.name = ?1")
	List<Student> findByName(String name);

}
