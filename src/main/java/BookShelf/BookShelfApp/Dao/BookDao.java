package BookShelf.BookShelfApp.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BookShelf.BookShelfApp.Entity.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

}
