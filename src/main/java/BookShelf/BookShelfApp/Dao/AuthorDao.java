package BookShelf.BookShelfApp.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BookShelf.BookShelfApp.Entity.Author;

@Repository
public interface AuthorDao extends CrudRepository<Author, Integer> {

}
