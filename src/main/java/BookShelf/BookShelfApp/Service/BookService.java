package BookShelf.BookShelfApp.Service;

import java.util.List;

import BookShelf.BookShelfApp.Dto.DTOBook;

public interface BookService {
	
	public DTOBook getBook(int id);
	
	public List<DTOBook> getAllBooks();
	
	public void deleteBook(int id);
	
	public DTOBook createBook(DTOBook book);
	
	public void updateBook(int id, DTOBook upd);
	
	

}
