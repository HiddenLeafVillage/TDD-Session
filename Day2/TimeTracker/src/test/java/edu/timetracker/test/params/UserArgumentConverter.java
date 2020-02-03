package edu.timetracker.test.params;

import java.util.UUID;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import edu.timetracker.model.User;

public class UserArgumentConverter extends SimpleArgumentConverter {

	@Override
	protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
		// TODO Auto-generated method stub
		String[] res = source.toString().split(",");
		return new User(UUID.fromString(res[0]), res[1]);
	}

}
