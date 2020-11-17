package com.seed.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.seed.domain.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Field must not be empty.")
	@Length(min = 5, max = 40, message = "Field must have the size between 1 and 40.")
	private String name;
	@NotEmpty(message = "Field must not be empty.")
	@Email(message = "Fild is invalid.")
	private String email;
	
	public ClientDTO() {
		super();
	}
	
	public ClientDTO(Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.email = client.getEmail();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
