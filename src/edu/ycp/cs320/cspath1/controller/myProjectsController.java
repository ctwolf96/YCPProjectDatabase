package edu.ycp.cs320.cspath1.controller;

import edu.ycp.cs320.cspath1.user.Student;
import edu.ycp.cs320.cspath1.user.User;
import edu.ycp.cs320.cspath1.email.EmailValidator;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.AccountCreationModel;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;

import java.io.IOException;
import java.sql.SQLException;

public class myProjectsController {
	private User user;
	private IDatabase db;
	
	public myProjectsController() {
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();
	}
	
public List<Pair<Author,Book>> getAllBooks() {
		
		// get the list of (Author, Book) pairs from DB
		List<Pair<Author, Book>> bookAuthorList = db.findAllBooksWithAuthors();
		ArrayList<Book> books = null;
		
		if (bookAuthorList.isEmpty()) {
			System.out.println("No books in database");
			return null;
		}
		else {
			books = new ArrayList<Book>();
			for (Pair<Author, Book> authorBook : bookAuthorList) {
				Author author = authorBook.getLeft();
				Book book = authorBook.getRight();
				books.add(book);
				System.out.println(book.getTitle() + ", " + book.getIsbn() + ", " + book.getPublished() + ", " + author.getLastname() + ", " + author.getFirstname());
			}			
		}
		
		// return list of book,author pairs
		return bookAuthorList;
	}
}