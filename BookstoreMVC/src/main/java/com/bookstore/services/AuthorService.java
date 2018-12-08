package com.bookstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.beans.Author;
import com.bookstore.util.Constants;

@Service("AuthorService")
public class AuthorService {

	//where we would autowire our daos but this is a dummy service
	static ArrayList<Author> authors = new ArrayList<Author>();
	static int seq = 100;

	static {
		authors.add(new Author(1, Constants.ROWLINGS, "I like string beans."));
		authors.add(new Author(2, Constants.FRANK, "The sleeper has awaken."));
		authors.add(new Author(3, Constants.BETTY, "I wrote something about a frog.")); 
		authors.add(new Author(4, Constants.KING, "I'm scared of the dark."));
		authors.add(new Author(5, Constants.TOLKIEN, "Only ring I have is in my tub."));
		authors.add(new Author(6, Constants.GOLDING, "Where is my Raid?"));
		
	}

	public List<Author> getAll(){
		return authors;
	}

	public Author getById(int id) {
		return authors.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}

	public Author getByAuthorName(String name) {
		return authors.stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	public Author addAuthor(Author author) {
		Author found = getByAuthorName(author.getName());
		if (found == null) {
			author.setId(seq++);
			authors.add(author);
			return author;
		} else {
			return null;
		}
	}

	public Author updateAuthor(int id, Author author) {
		Author old = getById(id);
		if (old == null) {
			return addAuthor(author);
		} else {
			// weird work around to change in-memory store of users
			for (Author s : authors) {
				if (s.getId() == id) {
					s.setName(author.getName());
					s.setBio(author.getBio());
					return s;
				}
			}
		}
		return null;
	}
}
