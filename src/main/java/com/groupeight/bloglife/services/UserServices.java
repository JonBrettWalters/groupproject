package com.groupeight.bloglife.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.groupeight.bloglife.models.LoginUser;
import com.groupeight.bloglife.models.User;
import com.groupeight.bloglife.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	UserRepository userRep;
	
	public List<User> allUsers(){
		return userRep.findAll();
	}
	public User createUser(User newUser, BindingResult result) {
		Optional<User> checkUser = userRep.findByEmail(newUser.getEmail());
		if(checkUser.isPresent()) {
			result.rejectValue("email", "unique", "User email is already taken.");
			return null;
		} else if (newUser.getPassword() == newUser.getConfirm()) {
			result.rejectValue("password", "mismatch", "Passwords must match");
			return null;
		}
		else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRep.save(newUser);
		}
	}
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> checkUser = userRep.findByEmail(newLogin.getEmail());
		if(!checkUser.isPresent()) {
			result.rejectValue("email", "missingEmail", "User does not exist");
			return null;
		}
		else if (!BCrypt.checkpw(newLogin.getPassword(), checkUser.get().getPassword())){
			result.rejectValue("password", "matches", "Email and Password do not match");
			return null;
		}
		else {
			return checkUser.get();
		}
	}
	public User findUser(Long id) {
		Optional<User> opUser = userRep.findById(id);
        if(opUser.isPresent()) {
            return opUser.get();
        } else {
            return null;
        }
	}
}
