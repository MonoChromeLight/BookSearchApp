package uni.fmi.books.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import uni.fmi.books.models.Author;
import uni.fmi.books.models.Book;
import uni.fmi.books.models.Genre;
import uni.fmi.books.repos.AuthorRepo;
import uni.fmi.books.repos.BookRepo;
import uni.fmi.books.repos.GenreRepo;

@RestController
public class BookManagerRest {
	private BookRepo bookRepo;
	private AuthorRepo authorRepo;
	private GenreRepo genreRepo;
	
	@Autowired
	public BookManagerRest(BookRepo bookRepo, AuthorRepo authorRepo) {
		this.bookRepo=bookRepo;
		this.authorRepo=authorRepo;
	}
	
	@PostMapping(path="/createBook")
	public String createBook(
			@RequestParam(name = "name") String b_name,
			@RequestParam(name = "genre") String g_name, 
			@RequestParam(name = "author") String a_name,
			HttpSession session) {
		
		Genre genre = new Genre(g_name);
		Author author = new Author(a_name);
		
		author=authorRepo.save(author);
		
		Book book= new Book(b_name,genre,author);
		book = bookRepo.save(book);
		
		//book= bookRepo.save(book);
		//book.setOwner(author);
		//author.addBook(book);
		//session.setAttribute("currentUser", authorRepo.save(author));
		if(book != null) {
			
			return book.getId()+"";
		}
		else {
			return "error";
		}
	}
	
	
	@RequestMapping(path="/editBook/")
	public void editBook(
			@RequestParam(value = "b_id") String b_id,
			HttpSession session) {
			Integer id=Integer.parseInt(b_id);
			
		    Book book = new Book();
		    book.setName("test");
		   
		  //  book =bookRepo.findById(id);
			
	}
	
	
	@PostMapping(path="/deleteBook")
	public String createBook(
			@RequestParam(name = "delete_id") Integer delete_id,
			HttpSession session) {
		Book book = new Book(delete_id);
		bookRepo.delete(book);
		
		return book.getId()+"";
	}

	@RequestMapping(path="/all")
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	@RequestMapping(path="/searchBy")
	public List<Book> findAllByName(
			@RequestParam(name = "name") String b_name){
		return bookRepo.findAllByNameIgnoreCaseContaining(b_name);
	}
}
