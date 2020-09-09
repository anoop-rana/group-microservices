package com.monolithic.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Post")
@NoArgsConstructor
@ToString
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter@Getter
	private Long pid;
	@Setter@Getter
	private String comments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter @JsonIgnore
	private User user;

	public Post(String comments) {
		super();
		this.comments = comments;
	}

	public void setUser(User user) {
		this.user = user;
		user.getComments().add(this);
	}
	
}
