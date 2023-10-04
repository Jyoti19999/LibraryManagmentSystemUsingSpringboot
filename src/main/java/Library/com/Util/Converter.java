package Library.com.Util;



import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import Library.com.Entities.Book;
import Library.com.Entities.User;
import Library.com.Model.BookDTO;
import Library.com.Model.UserDTO;


@Component
public class Converter {
	
	public  User convertToUserEntity(UserDTO userdto)
	{
	   User user=new User();
		if(userdto!=null)
		{
			BeanUtils.copyProperties(userdto, user);
		}
	     return user;
	}

	
	
	
	//convert from Entity to DTO
	public UserDTO convertToUserDTO(User user)
	{
		UserDTO userdto= new UserDTO();
		if(user!=null)
		{
			BeanUtils.copyProperties(user, userdto);
		}
		return userdto;
	}



	//convert from DTO to Entity 

	public  Book convertToBookEntity(BookDTO bookdto)
	{
		Book book=new Book();
		if(bookdto!=null)
		{
			BeanUtils.copyProperties(bookdto,book);
		}
	     return book;
	}

	//convert from Entity to DTO
	public BookDTO convertToBookDTO(Book book)
	{
		BookDTO bookdto=new BookDTO();
		if(book!=null)
		{
			BeanUtils.copyProperties(book, bookdto);
		}
		return bookdto;
	}

}
