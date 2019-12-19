package uni.fmi.books.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import uni.fmi.books.models.Book;


@Component
public class Service {
	private BookRepo bookRepo;
	
	@Autowired
	public Service(BookRepo bookRepo) {
		this.bookRepo=bookRepo;
	}
	
	public String getBook(String id) {
		final List<Book> books = new ArrayList<>();
		books.addAll(bookRepo.findById(Integer.parseInt(id)));
		return books.get(0).getName().toString();

	}

	public List<Book> findAll(String name) {
		final List<Book> books = new ArrayList<>();
		books.addAll(bookRepo.findAllByNameIgnoreCaseContaining(name));
		return books;
		
	}

	public List<Book> findGenre(String genre_id) {
		System.out.println("2"+genre_id);
		final List<Book> books = new ArrayList<>();
		books.addAll(bookRepo.findAllByGenre(genre_id));
		
		//System.out.println((bookRepo.findAllByNameIgnoreCaseContaining(name,genre,age)));
		return books;
	}

	public List<Book> findAllNandG(String name,String genre) {
		final List<Book> books = new ArrayList<>();
		books.addAll(bookRepo.findAllByNameIgnoreCaseContainingAndGenre(name,genre));
		return books;
		
	}
}
