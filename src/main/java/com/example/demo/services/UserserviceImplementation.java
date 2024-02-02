package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserserviceImplementation implements UserService{
@Autowired
UserRepository repo;
@Override
public String addUser(User user) {
	repo.save(user);
	return "user added successfully";
}
@Override
public boolean emailExists(String email) {
	// TODO Auto-generated method stub
	if(repo.findByEmail(email)==null) {
	return false;
	}
	else {
		return true;
	}
}
@Override
public boolean validateUser(String email,String password) {
	// TODO Auto-generated method stub
	User user=repo.findByEmail(email);
	String db_password=user.getPassword();
	if(password.equals(db_password)) {
		return true;
	}
	else {
		return false;
	}
}
@Override
public String getRole(String email) {
	// TODO Auto-generated method stub
	User user=repo.findByEmail(email);
	return user.getRole();
}
@Override
public User getUser(String email) {
	// TODO Auto-generated method stub
	return repo.findByEmail(email);
}
@Override
public void updateUser(User user) {
	// TODO Auto-generated method stub
	repo.save(user);
}
}
