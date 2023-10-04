package Library.com.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class User {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	 private Long id;
	 @Column(length=50)
	 private String name;
	 @Column(length=100)
	 private String address;
	 private boolean bookIssued=Boolean.FALSE;
	
	 
	@OneToMany(mappedBy="user")
	
	 @JsonIgnoreProperties("user")
	 List<Book> book;
	 
	    
	
}
