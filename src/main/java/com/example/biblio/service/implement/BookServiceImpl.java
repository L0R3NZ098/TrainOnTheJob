package com.example.biblio.service.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblio.enums.StateEnum;
import com.example.biblio.model.Book;
import com.example.biblio.model.User;
import com.example.biblio.repository.BookRepository;
import com.example.biblio.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> all = repository.findAll();
		return all;
	}

	@Override
	public Book getBookById(Long id) {
		Optional<Book> one = repository.findById(id);
		if (one.isPresent()) {
			return one.get();
		} else {
			return null;
		}
	}

	@Override
	public void addBook(Book book) {
		repository.save(book);
	}

	@Override
	public void updateBook(Long id, Book book) {
		Book update = this.getBookById(id);
		BeanUtils.copyProperties(book, update, "id");;
		repository.save(update);
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void lendBook(Long id, User user) {
		Book land = this.getBookById(id);
		if (land.getStato().equals(StateEnum.DISPONIBILE)) {
			land.setStato(StateEnum.PRESTATO);
			land.setUser(user);
			repository.save(land);
		}
	}

	@Override
	public void returnBook(Long id) {
		Book land = this.getBookById(id);
		if (land.getStato().equals(StateEnum.PRESTATO)) {
			land.setStato(StateEnum.DISPONIBILE);
			land.setUser(null);
			repository.save(land);
		}
	}

}
