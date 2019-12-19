package uni.fmi.books.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int g_id;
	

	private String g_name;

	
	@OneToMany(mappedBy="genre", fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	private List<Book> books;
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(int g_id, String g_name) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
	}

	/**
	 * @return the g_id
	 */
	public int getG_id() {
		return g_id;
	}

	/**
	 * @param g_id the g_id to set
	 */
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	/**
	 * @return the g_name
	 */
	public String getG_name() {
		return g_name;
	}

	/**
	 * @param g_name the g_name to set
	 */
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	
	
	
}
