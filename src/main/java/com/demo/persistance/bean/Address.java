package com.demo.persistance.bean;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	String StrNo;
	String StreetName;
    Long pin;
    
    public Address() {
    	
    }
    
    
    
	public Address(String strNo, String streetName, Long pin) {
		super();
		StrNo = strNo;
		StreetName = streetName;
		this.pin = pin;
	}



	public String getStrNo() {
		return StrNo;
	}
	public void setStrNo(String strNo) {
		StrNo = strNo;
	}
	public String getStreetName() {
		return StreetName;
	}
	public void setStreetName(String streetName) {
		StreetName = streetName;
	}
	public Long getPin() {
		return pin;
	}
	public void setPin(Long pin) {
		this.pin = pin;
	}	

    
}
