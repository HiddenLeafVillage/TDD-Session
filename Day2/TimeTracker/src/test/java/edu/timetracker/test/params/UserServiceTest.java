package edu.timetracker.test.params;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import edu.timetracker.model.RewardStatus;
import edu.timetracker.model.User;
import edu.timetracker.service.UserService;

public class UserServiceTest {
	
	@ParameterizedTest
	@ValueSource(strings = {"Siddharth", "Abhimanyu"})
	public void testAddUser(String name) {
		User user = new User(UUID.randomUUID(), name);
		UserService service = new UserService();
		assertEquals(user, service.addUser(user));
	}
	
	@ParameterizedTest
	@EnumSource(value=RewardStatus.class, names = "MARATHONER", mode=Mode.EXCLUDE)
	public void testEnum(RewardStatus status) {
		assertNotNull(status);
	}
	
	@ParameterizedTest
	@MethodSource("getUsers")
	public void testMethodSource(User user) {
		assertNotNull(user);
	}
	
	private static Stream<User> getUsers() {;
		return Stream.of(
				new User(UUID.randomUUID(), "Siddharth"),
				new User(UUID.randomUUID(), "Abhimanyu"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"14639215-6021-4e5d-b184-e834a1907a2d,Siddharth",
		"ef68e301-db8b-45f2-8142-138d55f1751c,Abhimanyu"
	})
	public void testCSVSource(UUID id, String name) {
		User user = new User(id, name);
		System.out.println(user);
		assertNotNull(user);
	}
	
	@ParameterizedTest
	@CsvSource({
		"14639215-6021-4e5d-b184-e834a1907a2d,Siddharth",
		"ef68e301-db8b-45f2-8142-138d55f1751c,Abhimanyu"
	})
	public void testCSVSourceAggregator(@AggregateWith(UserAggregator.class) User user) {
		System.out.println(user);
		assertNotNull(user);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = { "/data.csv" })
	public void testCSVFileSource(UUID id, String name) {
		User user = new User(id, name);
		System.out.println(user);
		assertNotNull(user);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = { "/data.csv" })
	public void testCSVFileSourceAggregator(@CsvToUser User user) {
		System.out.println(user);
		assertNotNull(user);
	}
	
	@ParameterizedTest
	@ValueSource(strings = "14639215-6021-4e5d-b184-e834a1907a2d,Siddharth")
	void testForArgmentConversion(@ConvertWith(UserArgumentConverter.class) User user) {
		System.out.println(user);
		assertNotNull(user);
	}
	
	
	
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = { " ", "   ", "Name"})
	void testNullEmptyAndBlankStrings(String text) {
	    assertTrue(text == null || text.trim().isEmpty() || text.equalsIgnoreCase("Name"));
	}
	
	
	
	
	@ParameterizedTest
	@ArgumentsSource(UserArgumentProvider.class)
	public void testArgumentSource(User user) {
		assertNotNull(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
