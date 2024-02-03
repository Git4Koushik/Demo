package com.demo.persistance.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

//@MappedSuperclass
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="Worker_Type")
public abstract class Worker {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	Long id;
	@Column(nullable=true)
	String name;

	public Worker() {
		
	}

	public Worker(String name) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + "]";
	}
	
	
}
