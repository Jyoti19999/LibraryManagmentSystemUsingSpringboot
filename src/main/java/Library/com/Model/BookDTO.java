package Library.com.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import Library.com.Entities.User;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class BookDTO {


	@NotNull
	private Long id;
	@NotNull
	@Column(length = 80)
    private String title;
	@Column(length = 50)
    private String author;
	
    private boolean borrowed=Boolean.FALSE;
    private Long assignedToStudent;
  
    private User  user;
}
