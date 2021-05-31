package com.zensar.spring.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.zensar.spring.model.User;
import com.zensar.spring.repository.UserRepository;
import com.zensar.spring.service.UserService;
import com.zensar.spring.utility.EmailVerification;
import com.zensar.spring.utility.Password;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public int register(User user) throws Exception {
		try {

			if (EmailVerification.sendGet(user.getEmail())) {
				User existedUser = repository.getByEmail(user.getEmail());
				if (existedUser != null) {
					return 400;
				} else {
					return 200;
				}
			} else {
				return 401;
			}
		} catch (DataIntegrityViolationException e) {
			return 400;
		}

	}

	@Override
	public int login(String email, String password) {
		User user = repository.getByEmail(email);
		if (user == null) {
			return 400;

		} else {

			Boolean validate = Password.checkPassword(password, user.getPassword());
			System.out.println(validate);
			if (validate) {
				return 200;
			} else {
				System.out.println("wrongpassword");
				return 401;
			}
		}

	}

	public User registerForm(User user) throws Exception {
		user.setPassword(Password.encrypt(user.getPassword()));
		return repository.save(user);

	}

}
