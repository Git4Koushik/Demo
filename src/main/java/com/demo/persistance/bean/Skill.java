package com.demo.persistance.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Skill {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 Long id;	
 String name;
	
 @ManyToMany(mappedBy="skills")
 @JsonIgnore
 List<Employee> emps = new ArrayList<>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Employee> getEmps() {
	return emps;
}

public void addEmp(Employee emp) {
	this.emps.add(emp);
}

@Override
public String toString() {
	return "Skill [id=" + id + ", name=" + name + ", emps=" + emps + ", getId()=" + getId() + ", getName()=" + getName()
			+ ", getEmps()=" + getEmps() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
 
 
 
}
