package com.iiht.training.eloan.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {	
	//Added one attribute and getters & setters for that which was not there as per entity

	private Long id;
	
	@NotNull(message="First Name is mandate")
	@NotBlank(message="First Name is mandate")
	@Size(min=3,max=100,message="First Name must be 3 to 100 chars in length")
	private String firstName;
	
	@NotNull(message="Last Name is mandate")
	@NotBlank(message="Last Name is mandate")
	@Size(min=3,max=100,message="Last Name must be 3 to 100 chars in length")
	private String lastName;
	
	@NotNull(message="Mail Id is mandate")
	@NotBlank(message="Mail Id is mandate")
	@Size(min=3,max=100,message="Mail Id must be 3 to 100 chars in length")
	@Email(message = "Email Id is not valied")
	private String email;
	
	@NotNull(message="Mobile number is mandate")
	@NotBlank(message="Mobile number is mandate")
	@Pattern(regexp = "[1-9][0-9]{9}",message = "Mobile number must be exactly ten digits")
	private String mobile;
	
	@NotNull(message="Role is mandate")
	@NotBlank(message="Role is mandate")
	private String role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
