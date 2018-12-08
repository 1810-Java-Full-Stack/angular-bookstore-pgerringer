package com.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.beans.Book;
import com.bookstore.services.BookService;

@RestController
@RequestMapping("/books") //this annotation can be applied to both classes and methods
public class BookController {
	@Autowired
	private BookService service;
	
	/**
	 * GET ALL 
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAll(){
		return service.getAll();
	}
	
	/**
	 * GET BY ID
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> findById(@PathVariable int id) {
		Book book = service.getById(id);
		
		if(book == null) {
			//return not found status
			return new ResponseEntity<Book>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			//return ok status
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
	}
	
	/**
	 * CREATE
	 * @param u
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addUser(@RequestBody Book book) {
		book = service.addBook(book);
		if(book == null) {
			return new ResponseEntity<Book>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Book>(book, HttpStatus.CREATED);
		}
	}
	
	//UPDATE 
	/**
	 * UPDATE
	 * @param id
	 * @param u
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateUser(@PathVariable int id, @RequestBody Book book){
		Book newBook = service.updateBook(id, book);
		if(newBook == null) {
			return new ResponseEntity<Book>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Book>(newBook, HttpStatus.OK);
		}
		
	}
}
