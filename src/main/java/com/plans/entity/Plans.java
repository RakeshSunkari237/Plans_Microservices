package com.plans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Plans {

	
	@Id
	@Column(name="paln_id")
	private String planId;
	
	private String planName;
	
	private String validity;
	private String description;
}
