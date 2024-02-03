package com.demo.persistance.bean;

import javax.persistence.Entity;

@Entity
public class FullTimeWorker extends Worker{

	Long Salary;
	
	public FullTimeWorker() {
		
	}
	
	public FullTimeWorker(String name,Long Salary) {
		super(name);
		this.Salary = Salary;
	}


	public Long getSalary() {
		return Salary;
	}

	public void setSalary(Long salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "FullTimeWorker [Salary=" + Salary + "]";
	}
	
	
	
}
