package com.demo.persistance.bean;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
		
	@ElementCollection
	@CollectionTable(name = "SHIRT_COLORS")
		       
	   @AttributeOverrides({
		 //     @AttributeOverride(name="key.pin", column=@Column(name="pin_code")),
		      @AttributeOverride(name="value.StrNo", column=@Column(name="str_no"))
	  })
	@MapKeyColumn(name = "Cust_No")
	Map<Long,Address> items = new HashMap<>();
	
	public OrderDetails() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Long, Address> getItems() {
		return items;
	}

	public void setItems(Map<Long, Address> items) {
		this.items = items;
	}

	
	
	
	
	
	
}
