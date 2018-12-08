package com.bookstore.beans;

import org.springframework.stereotype.Component;

@Component
public class Author {
	private int id;
    private String name;
    private String bio;
	
	public Author() {
	}

	public Author(int id, String name, String bio) {
		super();
		this.id = id;
		this.name = name;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Authors [id=" + id + ", name=" + name + ", bio=" + bio + "]";
	}
}
