package com.demo.persistance.bean;

import javax.persistence.Entity;

@Entity
public class PartTimeWorker extends Worker{

	Long hourlyWeaiges;

	
	public PartTimeWorker() {
	
	}
	
	public PartTimeWorker(String name,Long hourlyWeaiges) {
		super(name);
		this.hourlyWeaiges = hourlyWeaiges;
	}

	public Long getHourlyWeaiges() {
		return hourlyWeaiges;
	}

	public void setHourlyWeaiges(Long hourlyWeaiges) {
		this.hourlyWeaiges = hourlyWeaiges;
	}
	
	
	
}
