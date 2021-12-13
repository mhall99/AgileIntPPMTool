package io.agileintelligence.ppmtool.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Backlog {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private Integer PTSequence = 0;
	private String projectIdentifier;
	
	//OneToOne with project 
	
	//OneToMany projecttasks
	
	public Backlog() {
		
	}
	
	public Long getId() {
		return id;
	}

}
