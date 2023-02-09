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

import BookShelf.BookShelfApp.Dao.BookDao;
import BookShelf.BookShelfApp.Dto.DTOBook;
import BookShelf.BookShelfApp.Entity.Book;
import BookShelf.BookShelfApp.Exception.DaoException;
import BookShelf.BookShelfApp.Exception.ServiceException;
import BookShelf.BookShelfApp.Service.BookService;
import BookShelf.BookShelfApp.Util.HibernateUtils;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BookServiceImpl implements BookService {

	protected static final Logger log = LogManager.getLogger(BookServiceImpl.class);

	@Autowired
	BookDao bookDao;

	@Override
	public DTOBook getBook(int id) {
		try {
			log.info("Trying to find a book id: {}", id);

			ModelMapper md = new ModelMapper();
			Book book = bookDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
			DTOBook bookDto = md.map(book, new TypeToken<DTOBook>() {
			}.getType());

			return bookDto;

		} catch (DaoException ex) {
			log.info("Something went wrong while searching a book id: {} ", id);

			throw new ServiceException("Something went wrong while searching a book", ex);
		}

	}

	@Override
	public List<DTOBook> getAllBooks() {
		log.info("Trying to get all books");
		ModelMapper md = new ModelMapper();
		List<Book> books = (List<Book>) bookDao.findAll();

		List<DTOBook> booksDto = md.map(books, new TypeToken<List<DTOBook>>() {
		}.getType());

		return booksDto;

	}

	@Override
	public void deleteBook(int id) {
		try {
			log.info("Trying to delete a book id: {}", id);
			Book bToDelete = bookDao.findById(id).orElseThrow(() -> new EntityNotFoundException());

			bookDao.delete(bToDelete);
			log.info("Book was successfully deleted! Id: {}", id);

		} catch (DaoException ex) {
			log.info("Something went wrong while deleting a group");
			throw new ServiceException("Something went wrong while deleting a group", ex);
		}

	}

	@Override
	public DTOBook createBook(DTOBook bookDto) {

		try {
			log.info("Trying to create a book");

			Objects.requireNonNull(bookDto);
			ModelMapper md = new ModelMapper();

			Book book = md.map(bookDto, new TypeToken<Book>() {
			}.getType());

			bookDao.save(book);
			log.info("Book with id {} was successfully created!", book.getId());

			return this.getBook(book.getId());
		} catch (DaoException ex) {
			log.info("Something went wrong while creating a book");
			throw new ServiceException("Something went wrong while creating a book", ex);
		}

	}

	@Override
	public void updateBook(int id, DTOBook upd) {

		try {
			log.info("Trying to update a book id: {}", id);

			Book bUpd = bookDao.findById(id).orElseThrow(() -> new EntityNotFoundException());

			bUpd.setTitle(upd.getTitle());
			bUpd.setAuthor(upd.getAuthor());
			bUpd.setGenre(upd.getGenre());
			bUpd.setDescription(upd.getDescription());
			bUpd.setPublish_year(upd.getPublish_year());
			bUpd.setPublisher(upd.getPublisher());
			bUpd.setPages(upd.getPages());
			bUpd.setComment(upd.getComment());
			bUpd.setRate(upd.getRate());
			bUpd.setReading_stage(upd.getReading_progress());

			bookDao.save(bUpd);

			log.info("Book with id {} was successfully updated", id);

		} catch (DaoException ex) {
			log.info("Something went wrong while updating a book id: {}", id);
			throw new ServiceException("Something went wrong while updating a book", ex);

		}

	}

}
