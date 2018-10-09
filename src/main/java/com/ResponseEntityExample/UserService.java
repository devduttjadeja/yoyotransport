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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User currentUser) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

}
