package com.demo.persistance.reposirory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.persistance.bean.Employee;

@RepositoryRestResource(path="repo")
public interface SpringDataJpaRepo extends JpaRepository<Employee,Long>{
  
      List<Employee> findAll();	
}
