package uni.fmi.books.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uni.fmi.books.models.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
	public List<Book> findById(int id);
	
	public List<Book> findAllByNameIgnoreCaseContaining(String name);
	public List<Book> findAllByNameIgnoreCaseContainingAndGenre(String name,String genre);

	public List<Book> findAllByGenre(String genre);
	//public List<Book> findByPublicPostTrue();
	//public List<Book> findByPublicPost(final Author owner);
}
