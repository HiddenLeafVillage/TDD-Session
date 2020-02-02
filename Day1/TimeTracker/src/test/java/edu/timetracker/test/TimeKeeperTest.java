package edu.timetracker.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import edu.timetracker.model.RewardStatus;
import edu.timetracker.model.User;
import edu.timetracker.persistence.Persistence;
import edu.timetracker.service.TimeKeeper;

@DisplayName("Given user id")
public class TimeKeeperTest {
	
	@Nested
	@DisplayName("When user is created")
	public class FindCreatedUser {
		User user = null;
		TimeKeeper keeper = null;
		@BeforeEach
		public void setUp() {
			user = new User(UUID.randomUUID(), "Siddharth");
			Persistence.users.add(user);
			keeper = new TimeKeeper();
		}
		
		@Test
		@DisplayName("Then user exists on finding")
		public void testFindUser() {
			User savedUser = keeper.findUser(user.getId()).get();
			assertEquals(user, savedUser);
		}
	}
	
	@Nested
	@DisplayName("When user is not created")
	public class FindNonExistingUser {
		User user = null;
		TimeKeeper keeper = null;
		@BeforeEach
		public void setUp() {
			user = new User(UUID.randomUUID(), "Siddharth");
			keeper = new TimeKeeper();
		}
		
		@Test
		@DisplayName("Then throws no such element exception")
		public void testFindUser() {
			NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
				keeper.findUser(user.getId()).get();
			});
			assertNotNull(exception.getMessage());
		}
	}
	
	@Nested
	@DisplayName("When user completed running at marathoner time")
	public class GetResultStatus {
		User user = null;
		TimeKeeper keeper = null;
		@BeforeEach
		public void setUp() {
			user = new User(UUID.randomUUID(), "Siddharth");
			Persistence.users.add(user);
			keeper = new TimeKeeper();
			keeper.startAt(user.getId(), LocalDateTime.now());
			keeper.endAt(user.getId(), LocalDateTime.now().plusHours(4));
		}
		
		@Test
		@DisplayName("Then user is marathoner")
		public void testFindUser() {
			RewardStatus status = keeper.getReward(user.getId());
			assertEquals(RewardStatus.MARATHONER, status);
		}
	}
	
	
}
