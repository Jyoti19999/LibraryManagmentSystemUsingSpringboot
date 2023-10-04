package Library.com.Services;

import java.util.List;

import Library.com.Entities.User;
import Library.com.Model.UserDTO;

public interface UserService {

	public UserDTO save(User user);
	
	public List<UserDTO> findAllUser();
	
	public String deletById(Long id);
	
	public UserDTO getById(Long uid);

	public  UserDTO updateUser(Long uid, User user);
	
	
	
	
	
	
}
