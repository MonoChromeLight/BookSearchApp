package uni.fmi.books.vaadin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;


import uni.fmi.books.repos.Service;
import uni.fmi.books.models.Book;


//@RequestMapping("/vaadin")
@Route("")
public class VaadinUI extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Service service;
	private Grid<Book> grid=new Grid<>(Book.class);
	
	//@Autowired
	//private AuthorRepository authorRepo;
	//@Autowired
	//private BookRepository bookRepo;
	//@Override
	//protected void init(VaadinRequest request) {
	//	TextField name = new TextField("Enter book name");
	//	Button button = new Button("Search");
		
	//}
	
	public VaadinUI() {
		//MenuBar menuBar = new MenuBar();
		//Stream.of("Home", "Dashboard", "Content", "Structure", "Appearance",
		 //       "Modules", "Users", "Configuration", "Reports", "Help")
		  //      .forEach(menuBar::addItem);
		
		
		grid.setColumns("name","genre_name","age","author");
		//grid.addColumn(Book::getOwner).getElement();
		 TextField name = new TextField("Enter book name");
		 Button button = new Button("Clear");
	//	 Checkbox age1 = new Checkbox("1-4");
	//	 Checkbox age2 = new Checkbox("5-10");
	//	 Checkbox age3 = new Checkbox("10-15");
		 Select<String> genre = new Select<>();
		 
		 genre.setItems("Science", "Science fiction", "Children");
		 genre.setLabel("Genre");
		 
	//	 HorizontalLayout ages = new HorizontalLayout(age1,age2,age3);
		 
		 HorizontalLayout panel = new  HorizontalLayout(name,genre);
		 VerticalLayout layout = new VerticalLayout(button);
		 VerticalLayout books = new VerticalLayout(grid);
		 name.addValueChangeListener(e -> updateList(name.getValue(),genre.getItemPosition(genre.getValue())));
		 name.setValueChangeMode(ValueChangeMode.LAZY);
		// genre.addValueChangeListener(e -> updateList(name.getValue(),genre.getValue()));
		
		 button.addClickListener(e -> ClearAll()); /*Notification.show(service.getBook(name.getValue()))*/
		 add(panel,button, books); 
	}
	

	private void updateList(String name, Integer genre_id) {
		if((null==name)&&(0!=genre_id) ) {
			System.out.println("1"+genre_id);
			List<Book> books = service.findGenre((genre_id.toString()));
			grid.setItems(books);
		}
		if((null!=name)&&(0==genre_id) ) {
			System.out.println("2");
			List<Book> books = service.findAll(name.toString());
			grid.setItems(books);
		}
		if((null!=name)&&(null!=genre_id)) {
			//List<Book> books = service.findAllNandG(name.toString(),genre_id);
			//grid.setItems(books);
			System.out.println("1"+genre_id);
		}
		
	}

	private void ClearAll(){
		
	}
	}