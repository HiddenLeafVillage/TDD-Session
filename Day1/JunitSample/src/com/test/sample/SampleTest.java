package com.test.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.main.sample.Sample;

class SampleTest {

	@Test
	void test() {
		Sample sample = new Sample();
		Assertions.assertNotNull(sample.greet("Siddharth"));
		Assertions.assertEquals("Hello Sid", sample.greet("Siddharth"), "Invalid Greet");
	}

}
