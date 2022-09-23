
package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.exception.EmailAlreadyExistsException;
import com.kbe.shoppingapp.model.Component;
import com.kbe.shoppingapp.model.Currency;
import com.kbe.shoppingapp.model.User;
import com.kbe.shoppingapp.repository.ComponentRepository;
import com.kbe.shoppingapp.repository.CurrencyRepository;
import com.kbe.shoppingapp.repository.UserRepository;
import com.kbe.shoppingapp.repository.UserRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.userRepository.deleteAll();
	}

	@Override
	public User singUp(User user) throws EmailAlreadyExistsException {
		User exists = this.userRepository.findByEmail(user.email);
		if (exists != null) {
			throw new EmailAlreadyExistsException();
		}
		return this.userRepository.save(user);
	}

	@Override
	public User singIn(String email, String password) throws Exception {
		User user = this.userRepository.findByEmail(email);
		if (user == null) {
			throw new Exception("Email not found!");
		}
		if (user.password.equals(password)) {
			return user;
		}
		throw new Exception("Login error! Wrong email or password");
	}

	@Override
	public List<User> readAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User readByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


}