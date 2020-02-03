package edu.timetracker.service;

import static edu.timetracker.persistence.Persistence.users;

import java.util.Optional;
import java.util.UUID;

import edu.timetracker.model.User;
import edu.timetracker.persistence.Persistence;

public class UserService {
	
	public User addUser(User user) {
		Persistence.users.add(user);
		return user;
	}
	
	public User deleteUser(User user) {
		Persistence.users.remove(user);
		return user;
	}
	
	public Optional<User> findUser(UUID id) {
		return users.stream()
				.filter(x -> x.getId().equals(id))
				.findAny();
	}
}
