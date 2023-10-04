package Library.com.Services;


import java.util.List;

import Library.com.Entities.Book;
import Library.com.Entities.User;
import Library.com.Model.BookDTO;
import Library.com.Model.UserDTO;

public interface BookService {
	
	          
	public BookDTO save(Book book);
	 
	 public List<BookDTO> findAll();
	 
	 public String deleteById(Long id);
	 
	 public String borrowed(Long bookId, Long userId);
	 
	 public void returnBook(Long bookId,Long userId);
	 
	

//	BookDTO save(Library.com.Entities.Book book);

}
