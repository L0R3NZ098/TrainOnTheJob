package com.example.biblio.service;

import java.util.List;
import com.example.biblio.model.Book;
import com.example.biblio.model.User;

public interface BookService {
	
	public List<Book> getAllBooks();
	public Book getBookById(Long id);
	public void addBook(Book book);
	public void updateBook(Long id, Book book);
	public void deleteBook(Long id);
	public void lendBook(Long id, User user);
	public void returnBook(Long id);
	
}
