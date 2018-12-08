package com.bookstore.beans;

import org.springframework.stereotype.Component;

@Component
public class Book {
	
	private int id;
    private String name;
    private int author_id;
    private String isbn;
    
	public Book() {
		super();
	}

	public Book(int id, String name, int author_id, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.author_id = author_id;
		this.isbn = isbn;
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

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}