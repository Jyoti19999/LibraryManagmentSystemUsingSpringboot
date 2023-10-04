package Library.com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Library.com.Util.Converter;
import Library.com.Entities.Book;
import Library.com.Entities.User;
import Library.com.Model.BookDTO;
import Library.com.Model.UserDTO;
import Library.com.Services.BookService;


@RestController
public class BookController {

	@Autowired
	BookService bookservice;
	
	@Autowired
	Converter converter;
	
	@PostMapping("/addbook")
	ResponseEntity<BookDTO> Addbook(@RequestBody BookDTO bookdto) {
		final Book book = converter.convertToBookEntity(bookdto);
		return new ResponseEntity<BookDTO>(bookservice.save(book), HttpStatus.CREATED);
	}
	

	
	@DeleteMapping("/deleteBookById/{bid}")
	String deleteById(@PathVariable Long bid) {
		return bookservice.deleteById(bid);	
	}
	
	
	@GetMapping("/getAllBooks")
	List<BookDTO> getAllBook(){
		return bookservice.findAll();
		
	}
	
	
	@PostMapping("/borrowbook/{bid}/{uid}")
	public String issueBook(@PathVariable Long bid,
			@PathVariable Long uid)
	{
		return bookservice.borrowed(bid, uid);
	}
	
	@PutMapping("returnBook/{userId}/{bookId}")
    public ResponseEntity<String> returnBook(
            @PathVariable Long userId,
            @PathVariable Long bookId
    ) {
		bookservice.returnBook(userId, bookId);
        return ResponseEntity.ok("Book returned successfully.");
    }
	
	
	
	
	
}
