package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleTest {
	
	@Test
	public void test() {
		Greeter greeter = new Greeter();
		Assertions.assertNotNull(greeter.greet("Siddharth Abhimanyu"));
		Assertions.assertEquals("Hello Siddharth Abhimanyu", greeter.greet("Siddharth Abhimanyu"));
	}
}
