package Library.com.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Auto.Entity.Student;
import Auto.Entity.Teacher;
import Library.com.Entities.User;
import Library.com.Exception.ResourceNotFoundException;
import Library.com.Model.BookDTO;
import Library.com.Model.UserDTO;
import Library.com.Repository.BookRepository;
import Library.com.Repository.UserRepository;
import Library.com.Services.BookService;
import Library.com.Util.Converter;
import Library.com.Entities.Book;

@Transactional
@Service
public class BookServiceImp  implements BookService{


	@Autowired
	Converter converter;
	
	@Autowired
	BookRepository bookrepo;
	
	@Autowired
	UserRepository userrepo;

	@Override
	public BookDTO save(Book book) {
		Book book1=bookrepo.save(book);
		return  converter.convertToBookDTO(book1);
	}

	@Override
	public List<BookDTO> findAll() {
		List<Book> booklist=bookrepo.findAll(); 
		List<BookDTO> bookdtolist=new ArrayList<>();
		
		for(Book b:booklist) {
		 bookdtolist.add(converter.convertToBookDTO(b));
		}
		return bookdtolist;
	}

	
	@Override
	public String deleteById(Long id) {
		bookrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Book", "Id", id));
		bookrepo.deleteById(id);
		
		return "Book deleted sucessfully!!";
	}

	
	
	@Override
	public String borrowed(Long bookId, Long userId) {
		User u=userrepo.findById(userId).orElseThrow(()->
		new ResourceNotFoundException("User", "Id", userId));
		
		Book b=bookrepo.findById(bookId).orElseThrow(()->
		new ResourceNotFoundException("Book", "Id", bookId));
		
		List<Book> blist=new ArrayList<>();
		
		blist.add(b);
		u.setBook(blist);
		u.setBookIssued(true);
		b.setUser(u);
		
		b.setBorrowed(true);
		bookrepo.save(b);
		return "book issued!!";
	}

	

	
	public void returnBook(Long userId, Long bookId) {
        User user = userrepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));
        Book book = bookrepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found."));

        // Check if the user holds the book
        if (user.getBook().contains(book)) {
            user.getBook().remove(book);
           // user.setHoldsBooks(!user.getBook().isEmpty()); // Update holdsBooks field
            user.setBookIssued(!user.getBook().isEmpty());
            book.setBorrowed(false); // Mark the book as returned
            userrepo.save(user);
            bookrepo.save(book);
        } else {
            throw new RuntimeException("User does not hold this book.");
        }
    }

	
	

	
	
	
	
	
}
