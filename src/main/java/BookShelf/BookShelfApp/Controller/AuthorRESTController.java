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

import BookShelf.BookShelfApp.Dto.DTOAuthor;
import BookShelf.BookShelfApp.Service.AuthorService;

@RestController
@RequestMapping(value = "/api/authors")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorRESTController {

	private static Logger log = LogManager.getLogger(AuthorRESTController.class);

	@Autowired
	AuthorService serviceAuthor;

	@GetMapping(value = "/")
	public List<DTOAuthor> getAllAuthors() {
		log.info("Trying to get all authors REST");

		return serviceAuthor.getAllAuthors();

	}

	@GetMapping(value = "/{id}")
	public DTOAuthor getAuthorById(@PathVariable("id") int id) {
		log.info("Trying to get an author REST with id: {}", id);

		return serviceAuthor.getAuthorById(id);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable("id") int id) {
		log.info("Trying to delete an author REST id: {}", id);

		serviceAuthor.deleteAuthor(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PostMapping(value = "/")
	public DTOAuthor createAuthor(@RequestBody DTOAuthor aDto) {
		log.info("Trying to create an author REST");

		DTOAuthor aCreate = new DTOAuthor();
		aCreate.setName(aDto.getName());
		aCreate.setSurname(aDto.getSurname());
		aCreate.setCountry(aDto.getCountry());
		aCreate.setBorn_date(aDto.getBorn_date());
		aCreate.setDeath_date(aDto.getDeath_date());
		aCreate.setGenre(aDto.getGenre());
		aCreate.setDescription(aDto.getDescription());
		aCreate.setAlive(aDto.isAlive());
		aCreate.setComment(aDto.getComment());

		serviceAuthor.createAuthor(aCreate);

		log.info("Author with id: {} was successfully created", aCreate.getId());

		return aCreate;

	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<String> updateAuthor(@PathVariable("id") int id, @RequestBody DTOAuthor upd) {
		log.info("trying to update an author REST id: {}", id);

		serviceAuthor.updateAuthor(id, upd);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
