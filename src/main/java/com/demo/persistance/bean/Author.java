package com.demo.persistance.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue
	Long id;
	
	String Name;

	@ElementCollection
	Set<Address> address = new HashSet<>();
	
	
   
	public Author(){
		
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}


	public Set<Address> getAddress() {
		return address;
	}


	public void setAddress(Set<Address> address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", Name=" + Name + ", address=" + address + "]";
	}


	
}
