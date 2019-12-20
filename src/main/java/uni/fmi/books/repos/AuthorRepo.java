package uni.fmi.books.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.fmi.books.models.Author;

public interface AuthorRepo extends JpaRepository<Author,Integer>{

}
