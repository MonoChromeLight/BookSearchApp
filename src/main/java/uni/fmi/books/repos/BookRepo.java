package uni.fmi.books.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.fmi.books.models.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
	public List<Book> findById(int id);
	public List<Book> findAll();
	
	
	public List<Book> findAllByNameIgnoreCaseContaining(String name);
	
	public List<Book> findAllByNameIgnoreCaseContainingAndGenre(String name,String genre);
	
	
	public List<Book> findAllByGenre(String genre);
	
	 
}
