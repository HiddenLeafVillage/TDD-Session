package edu.timetracker.test.params;

import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import edu.timetracker.model.User;

public class UserArgumentProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
				Arguments.of(new User(UUID.randomUUID(), "Siddharth")),
				Arguments.of(new User(UUID.randomUUID(), "Abhimanyu")));
	}

}
