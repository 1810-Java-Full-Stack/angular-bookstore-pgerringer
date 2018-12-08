package com.bookstore.beans;

import org.springframework.stereotype.Component;

@Component
public class Book {
	
	private int id;
    private String name;
    private String author;
    private String isbn;
    
	public Book() {
		super();
	}

	public Book(int id, String name, String author, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}