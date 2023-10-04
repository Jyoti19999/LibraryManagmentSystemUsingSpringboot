package Library.com.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Auto.Entity.Student;
import Auto.Model.StudentDTO;
import Library.com.Entities.User;
import Library.com.Exception.ResourceNotFoundException;
import Library.com.Model.UserDTO;
import Library.com.Repository.UserRepository;
import Library.com.Services.UserService;
import Library.com.Util.Converter;


@Transactional
@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	Converter converter;
	
	
	@Override
	public UserDTO save(User user) {
		
		User user1=userrepo.save(user);
		
		return converter.convertToUserDTO(user1);
	}

	
	@Override
	public List<UserDTO> findAllUser() {
		
		List<User> userlist=userrepo.findAll();
		
		List<UserDTO> userdtolist=new ArrayList <>();
		
		for(User u:userlist) {
			
			userdtolist.add(converter.convertToUserDTO(u));
			
		}
		
		return userdtolist;
	}
	
	
	

	@Override
	public String deletById(Long id) {
		
		userrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("User", "Id", id));
		
		
		userrepo.deleteById(id);
		
		return "User deleted successfully!!";
		
		
	}

	@Override
	public UserDTO updateUser(Long uid, User user) {
		
		User u=userrepo.findById(uid).orElseThrow(()->
		new ResourceNotFoundException("User", "Id", uid));
		//u.setId(user.getId());
		u.setBook(user.getBook());
		u.setAddress(user.getAddress());
		u.setName(user.getName());	
		User user1=userrepo.save(u);
		
		return converter.convertToUserDTO(user1);
	}

	

	
	@Override
	public UserDTO getById(Long uid) {
		User user=userrepo.findById(uid).orElseThrow(()->
		new ResourceNotFoundException("User", "Id", uid));
		return converter.convertToUserDTO(user);	
	}	
	
	
}
