package BookShelf.BookShelfApp.Service.Implementation;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookShelf.BookShelfApp.Dao.AuthorDao;
import BookShelf.BookShelfApp.Dto.DTOAuthor;
import BookShelf.BookShelfApp.Entity.Author;
import BookShelf.BookShelfApp.Exception.DaoException;
import BookShelf.BookShelfApp.Exception.ServiceException;
import BookShelf.BookShelfApp.Service.AuthorService;
import BookShelf.BookShelfApp.Util.HibernateUtils;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorServiceImpl implements AuthorService {
	protected static final Logger log = LogManager.getLogger(AuthorServiceImpl.class);

	@Autowired
	AuthorDao authorDao;

	@Override
	public DTOAuthor getAuthorById(int id) {
		try {
			log.info("Trying to find an author");
			ModelMapper md = new ModelMapper();
			Author aFind = authorDao.findById(id).orElseThrow(() -> new EntityNotFoundException());

			DTOAuthor authDto = md.map(aFind, new TypeToken<DTOAuthor>() {
			}.getType());

			return authDto;

		} catch (DaoException ex) {
			log.info("Something went wrong while finding an author id {}", id);

			throw new ServiceException("Something went wrong while finding an author ", ex);
		}

	}

	@Override
	public List<DTOAuthor> getAllAuthors() {
		log.info("Trying to fing all authors");
		ModelMapper md = new ModelMapper();
		List<Author> authorList = (List<Author>) authorDao.findAll();
		log.info("All Authors {} ", authorList);
		List<DTOAuthor> authorListDto = md.map(authorList, new TypeToken<List<DTOAuthor>>() {
		}.getType());

		return authorListDto;

	}

	@Override
	public DTOAuthor createAuthor(DTOAuthor authorDto) {
		try {

			Objects.requireNonNull(authorDto);
			log.info("Trying to add an author");
			ModelMapper md = new ModelMapper();

			Author newAuthor = md.map(authorDto, new TypeToken<Author>() {
			}.getType());
			log.info("Info Author {} ", newAuthor);

			authorDao.save(newAuthor);
			log.info("Author was successfully added");
			return this.getAuthorById(newAuthor.getId());

		} catch (DaoException ex) {
			log.info("Something went wrong");
			throw new ServiceException("Something went wrong while creating an author", ex);

		}

	}

	@Override
	public void deleteAuthor(int id) {
		try {
			log.info("Trying to delete an author with id {} ", id);

			Author aToDelete = authorDao.findById(id).orElseThrow(() -> new EntityNotFoundException());

			authorDao.delete(aToDelete);

			log.info("Author id {} was successfully deleted", id);

		} catch (DaoException ex) {
			log.info("Something went wrong while deleting an auhtor");
			throw new ServiceException("Something went wrong while deleting an auhtor", ex);
		}

	}

	@Override
	public void updateAuthor(int id, DTOAuthor upd) {
		try {
			log.info("Trying to update an author");
			Author toUpd = authorDao.findById(id).orElseThrow(() -> new EntityNotFoundException());

			toUpd.setName(upd.getName());
			toUpd.setSurname(upd.getSurname());
			toUpd.setCountry(upd.getCountry());
			toUpd.setGenre(upd.getGenre());
			toUpd.setBorn_date(upd.getBorn_date());
			toUpd.setDeath_date(upd.getDeath_date());
			toUpd.setDescription(upd.getDescription());
			toUpd.setComment(upd.getComment());
			toUpd.setAlive(upd.isAlive());

			authorDao.save(toUpd);

		} catch (DaoException ex) {
			log.info("Something went wrong while updating author id: {}", id);
			throw new ServiceException("Something went wrong while updating author", ex);
		}

	}

}
