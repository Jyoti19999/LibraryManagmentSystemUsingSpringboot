package Library.com.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Library.com.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	

}
