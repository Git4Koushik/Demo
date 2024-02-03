package com.demo.persistance.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@Cacheable
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String name;
	String dept;
	Long managerId;
	
	@Embedded
	Address address;
	
	@ManyToMany
	@JoinTable(name="emp_skill",joinColumns=@JoinColumn(name="employee"),inverseJoinColumns=@JoinColumn(name="skill"))
	List<Skill> skills = new ArrayList<>();
	
	public Employee(){
		
	}
	
	public Employee(String name, String dept, Long managerId) {

		this.name = name;
		this.dept = dept;
		this.managerId = managerId;
	}
	
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	
		
	public List<Skill> getSkills() {
		return skills;
	}

	public void addSkill(Skill skill) {
		this.skills.add(skill) ;
	}
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", managerId=" + managerId + "]";
	}
	
	
	
	
}
