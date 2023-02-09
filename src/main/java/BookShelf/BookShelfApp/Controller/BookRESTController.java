package BookShelf.BookShelfApp.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BookShelf.BookShelfApp.Dto.DTOBook;
import BookShelf.BookShelfApp.Service.BookService;

@RestController
@RequestMapping(value = "/api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookRESTController {

	private static Logger log = LogManager.getLogger(BookRESTController.class);

	@Autowired
	BookService serviceBook;

	@GetMapping(value = "/")
	public List<DTOBook> getAllBooks() {
		log.info("Trying to get all books REST");

		return serviceBook.getAllBooks();

	}

	@GetMapping(value = "/{id}")
	public DTOBook getBookById(@PathVariable("id") int id) {
		log.info("Trying to find a book REST by id: {}", id);

		return serviceBook.getBook(id);
	}

	@PostMapping(value = "/")
	public DTOBook createBook(@RequestBody DTOBook bDto) {
		log.info("Trying to create a new book REST");
		DTOBook bCreate = new DTOBook();
		bCreate.setTitle(bDto.getTitle());
		bCreate.setGenre(bDto.getGenre());
		bCreate.setAuthor(bDto.getAuthor());
		bCreate.setDescription(bDto.getDescription());
		bCreate.setPages(bDto.getPages());
		bCreate.setPublish_year(bDto.getPublish_year());
		bCreate.setPublisher(bDto.getPublisher());
		bCreate.setComment(bDto.getComment());
		bCreate.setRate(bDto.getRate());
		bCreate.setReading_progress(bDto.getReading_progress());

		serviceBook.createBook(bCreate);
		log.info("Book with id: {} was created!", bCreate.getId());

		return serviceBook.getBook(bCreate.getId());

	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<String> updateBook(@PathVariable("id") int id, @RequestBody DTOBook bUpd) {
		log.info("Trying to update a book with id: {}", id);

		serviceBook.updateBook(id, bUpd);

		log.info("Book has been updated, id: {}", bUpd.getId());

		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
		log.info("Trying to delete REST a book with id: {}", id);
		
		serviceBook.deleteBook(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
 
}
