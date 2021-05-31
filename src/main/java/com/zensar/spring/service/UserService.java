package com.zensar.spring.service;

import com.zensar.spring.model.User;

public interface UserService {

	int register(User user) throws Exception;

	int login(String email, String password);

	User registerForm(User user) throws Exception;

}
