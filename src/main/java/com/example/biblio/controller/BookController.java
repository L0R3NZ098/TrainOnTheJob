package com.example.biblio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.biblio.model.Book;
import com.example.biblio.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> getAll = service.getAllBooks();
		return ResponseEntity.ok().body(getAll);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Book> getById(@PathVariable(value = "id") Long id) {
		Book getById = service.getBookById(id);
		return ResponseEntity.ok().body(getById);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		 service.addBook(book);
		 return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBook(@PathVariable(value = "id") Long id, @RequestBody Book book) {
		service.updateBook(id, book);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long id) {
		service.deleteBook(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/tolend/{id}")
	public ResponseEntity<?> lendBook(@PathVariable(value = "id") Long id) {
		service.lendBook(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/toreturn/{id}")
	public ResponseEntity<?> returnBook(@PathVariable(value = "id") Long id) {
		service.returnBook(id);
		return ResponseEntity.ok().build();
	}
	
}
