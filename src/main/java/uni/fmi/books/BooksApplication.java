package uni.fmi.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.spring.annotation.EnableVaadin;;

@EnableVaadin({"uni.fmi.books.vaadin"})
@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	

}
