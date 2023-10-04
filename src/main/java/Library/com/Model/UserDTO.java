package Library.com.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import Library.com.Entities.Book;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDTO {

	@NotNull
	 private Long id;
	 @Column(length=50)
	 @NotNull
	 private String name;
	
	 @Size(min =5,max=100,message = "Address should have min 5 to max 100 characters")
	 private String address;

	 private boolean bookIssued=Boolean.FALSE;
	 List<Book> book;
	
	 
	 
	 
	 
}
