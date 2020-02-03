package edu.timetracker.test.extensions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import edu.timetracker.model.User;
import edu.timetracker.service.UserService;

@ExtendWith(UserServiceResolver.class)
public class UserServiceResolverTest {

	@Test
	public void test(UserService service) {
		User user = service.addUser(new User(UUID.randomUUID(), "Siddharth"));
		assertNotNull(user);
	}
}
