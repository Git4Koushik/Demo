package com.demo.persistance.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable=true)
	String name;
	
	 @OneToOne(/*cascade= CascadeType.ALL,*/fetch=FetchType.LAZY)
	 @JoinColumn(name = "fk_order")
	 Passport passport;

     @OneToMany(mappedBy="stud" )
     List<Book> books;
	
	
	public Student() {
		
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
    public List<Book> getBooks() {
		return books;
	}

	public void addBook(Book book){
		this.books.add(book);
	}
    
    public void removeBook(Book book){
    	
    	this.books.remove(book);
    }
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}
	
	
	
	

}
