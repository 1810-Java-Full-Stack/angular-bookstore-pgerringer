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

import com.bookstore.beans.Author;
import com.bookstore.services.AuthorService;

@RestController
@RequestMapping("/authors") //this annotation can be applied to both classes and methods
public class AuthorController {
	@Autowired
	private AuthorService service;
	
	/**
	 * GET ALL 
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Author> getAll(){
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
	public ResponseEntity<Author> findById(@PathVariable int id) {
		Author author = service.getById(id);
		
		if(author == null) {
			//return not found status
			return new ResponseEntity<Author>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			//return ok status
			return new ResponseEntity<Author>(author, HttpStatus.OK);
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
	public ResponseEntity<Author> addUser(@RequestBody Author author) {
		author = service.addAuthor(author);
		if(author == null) {
			return new ResponseEntity<Author>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Author>(author, HttpStatus.CREATED);
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
	public ResponseEntity<Author> updateUser(@PathVariable int id, @RequestBody Author author){
		Author newAuthor = service.updateAuthor(id, author);
		if(newAuthor == null) {
			return new ResponseEntity<Author>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Author>(newAuthor, HttpStatus.OK);
		}
		
	}
}
