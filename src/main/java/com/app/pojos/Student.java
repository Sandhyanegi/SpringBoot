package com.app.pojos;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="new_students")

@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter
@ToString(exclude = "password")
public class Student extends BaseEntity {
	
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30,unique = true)
	private String email;
	
	@Column(length = 20,nullable = false)	
	@JsonProperty(access = Access.WRITE_ONLY) 
	private String password;
	
	private String Course;
	private String location;
	private LocalDate joinDate;
	private double marks;


	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
}
