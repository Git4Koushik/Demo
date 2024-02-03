package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistance.bean.Employee;

import com.demo.persistance.reposirory.DemoRepo;

@RestController
public class ControllerService {
@Autowired
DemoRepo repository ;
	@GetMapping("test")
	public List<Employee> func() {
		
		return repository.findAllEmp();
	}
}
