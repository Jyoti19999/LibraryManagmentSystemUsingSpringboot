package Library.com.Controller;

import java.util.List;
import javax.validation.Valid;
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

import Auto.Entity.Student;
import Auto.Model.StudentDTO;
import Library.com.Entities.User;
import Library.com.Model.UserDTO;
import Library.com.Services.UserService;
import Library.com.Util.Converter;

@RestController
public class UserController {

	
	@Autowired
	UserService usersservice;
	
	@Autowired
	
	Converter converter;
	
	@PostMapping("/createUser")
	ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto) {
		final User user = converter.convertToUserEntity(userdto);
		return new ResponseEntity<UserDTO>(usersservice.save(user), HttpStatus.CREATED);
	}

	@GetMapping("/getById/{uid}")
	UserDTO getUserById(@PathVariable Long uid) {
		return usersservice.getById(uid);
	
	}
	

	
	@GetMapping("/getAllusers")
	List<UserDTO> getAllUser(){
		return usersservice.findAllUser();	
	}
	
	@PutMapping("/updateuserdetails/{uid}")
	UserDTO updateUser(@Valid @PathVariable Long uid ,@RequestBody UserDTO userdto) {
		
	final User user=converter.convertToUserEntity(userdto);
	return usersservice.updateUser(uid, user);
	
	}
	
	
	@DeleteMapping("/deleteuser/{uid}")
	String deleteUser(@PathVariable Long uid) {
		return usersservice.deletById(uid);	
	}
	
	
	
}
