package com.ResponseEntityExample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	List<User> userList = new ArrayList<User>();
	
	public UserService() {
		
		userList.add(new User(1,"Devdutt",27,500));
		
	}

	public List<User> findAllUsers() {
		return userList;
	}

	public User findById(long id) {
		return null;
	}

	public boolean isUserExist(User user) {
		return false;
	}

	public void saveUser(User user) {
		
	}

	public void updateUser(User currentUser) {
		
	}

	public void deleteUserById(long id) {
		
	}

	public void deleteAllUsers() {
		
	}

}
