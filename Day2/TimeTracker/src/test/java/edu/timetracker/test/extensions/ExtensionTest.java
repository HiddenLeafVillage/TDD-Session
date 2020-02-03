package edu.timetracker.test.extensions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(LifeCycleExtensions.class)
public class ExtensionTest {
	
	@BeforeAll
	static void testBeforeAll() {
		System.out.println("BeforeAll");
	}
	
	@Test
	void test() {
		
	}
}
