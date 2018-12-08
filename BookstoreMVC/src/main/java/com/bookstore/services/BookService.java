package com.bookstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.beans.Book;
import com.bookstore.util.Constants;

@Service("bookService")
public class BookService {
	//where we would autowire our daos but this is a dummy service
	static ArrayList<Book> books = new ArrayList<Book>();
	static int seq = 100;

	static {
		books.add(new Book(1, "Sorcers Stone", Constants.ROWLINGS, "alsdjfoiaf"));
		books.add(new Book(13, "Dune", Constants.FRANK, "alsdjfoiaf"));
		books.add(new Book(15, "Life According to Og the Frog", Constants.BETTY, "alsdjfoiaf"));
		books.add(new Book(20, "IT", Constants.KING, "alsdjfoiaf"));
		books.add(new Book(20, "The Hobbit", Constants.TOLKIEN, "kdkjdfsiao9430q"));
	}

	public List<Book> getAll(){
		return books;
	}

	public Book getById(int id) {
		return books.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}

	public Book findByBookname(String bookname) {
		return books.stream().filter(t -> t.getName().equalsIgnoreCase(bookname)).findFirst().orElse(null);
	}

	public Book addBook(Book book) {
		Book found = findByBookname(book.getName());
		if (found == null) {
			book.setId(seq++);
			books.add(book);
			return book;
		} else {
			return null;
		}
	}

	public Book updateBook(int id, Book book) {
		Book old = getById(id);
		if (old == null) {
			return addBook(book);
		} else {
			// weird work around to change in-memory store of users
			for (Book s : books) {
				if (s.getId() == id) {
					s.setIsbn(book.getIsbn());
					s.setName(book.getName());
					s.setAuthor(book.getAuthor());
					return s;
				}
			}
		}
		return null;
	}
}
