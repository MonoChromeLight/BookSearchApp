package uni.fmi.books.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.fmi.books.models.Genre;

public interface GenreRepo extends JpaRepository<Genre, Integer> {

	//Genre findByName(String g_name);
	//List<Genre> findAllById(Integer g_id);
}
