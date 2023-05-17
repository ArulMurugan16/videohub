package com.videohub.videohub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class EndUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_generator")
	@SequenceGenerator(name = "user_generator")
	@Column(name = "user_id")
    private Long id;
	
	
	

	@Column(name = "name")
    private String name;
	@Column(name = "password")
    private String password;
	@Column(name = "mail")
    private String mail;
    
    public EndUser() {
        // Empty constructor needed for Spring Boot
    }
    public EndUser(Long id, String name, String password, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mail = mail;
	}
 
    // Getters and setters for the fields
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
}
