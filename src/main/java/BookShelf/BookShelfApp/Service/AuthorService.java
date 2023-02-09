package BookShelf.BookShelfApp.Service;

import java.util.List;

import BookShelf.BookShelfApp.Dto.DTOAuthor;

public interface AuthorService {
	
	public DTOAuthor getAuthorById(int id);
	
	public List<DTOAuthor> getAllAuthors();
	
	public DTOAuthor createAuthor(DTOAuthor author);
	
	public void deleteAuthor(int id);
	
	public void updateAuthor(int id, DTOAuthor upd);
	

}
