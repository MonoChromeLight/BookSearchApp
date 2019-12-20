package uni.fmi.books.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int a_id;
	private String a_name;
	
	@OneToMany(mappedBy="owner", fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	
	private List<Book> books;
	
	public Author() {
		
	}
	
	public Author(String a_name) {
		super();
		this.a_name = a_name;
	}

	public Author(int a_id, String a_name) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
	}

	/**
	 * @return the a_id
	 */
	public int getId() {
		return a_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int a_id) {
		this.a_id = a_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return a_name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String a_name) {
		this.a_name = a_name;
	}

	/**
	 * @return the posts
	 */
	public List<Book> getBooks() {
		if (null == books) {
			books = new ArrayList<>();
		}
		return books;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		getBooks().add(book);
		
	}

	
	
	
	
}
