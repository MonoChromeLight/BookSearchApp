package uni.fmi.books.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@JsonIgnoreProperties({"genre","owner"})
public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Genre genre;
	@JsonInclude()
	@Transient
	private String genre_name;
	@JsonInclude()
	@Transient
	private String author;
	
	@ManyToOne(fetch = FetchType.EAGER)	
	private Author owner;
	
	public Book() {
		
	}
	public Book(Integer id) {
		this.id=id;
	}

	public Book(String name, Genre genre, Author author) {
		super();
		this.name = name;
		this.genre=genre;
		this.owner=author;
	}
/*	public Book(String name, Integer b_genre, String age, Integer b_author) {
		super();
		this.name = name;
		this.genre.setG_id(b_genre);
		this.age=age;
		this.owner.setId(b_author);
		this.owner.setName(b_author.toString());
	}  */
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	

	/**
	 * @return the genre_name
	 */
	public String getGenre_name() {
		return genre.getG_name();
	}

	/**
	 * @param genre_name the genre_name to set
	 */
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return owner.getName();
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the owner
	 */
	public Author getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Author owner) {
		this.owner = owner;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	
}
