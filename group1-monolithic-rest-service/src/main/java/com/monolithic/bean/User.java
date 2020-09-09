package com.monolithic.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uid;
	private String name;
	private Integer age;
	private Long phone;
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Post> comments=new ArrayList<>();
	
	
	public User(String name, Integer age, Long phone, String email) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	
}
