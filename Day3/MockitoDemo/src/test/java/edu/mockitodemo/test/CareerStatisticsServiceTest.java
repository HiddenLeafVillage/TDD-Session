package edu.mockitodemo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.mockitodemo.helper.CareerStatisticsHelper;
import edu.mockitodemo.service.CareerStatisticsService;

public class CareerStatisticsServiceTest {
	
	@Mock
	CareerStatisticsHelper helper;

	@InjectMocks
	CareerStatisticsService service;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Disabled
	@Test
	void implicitMatcher() {
		Mockito.when(helper.calculateStrikeRate(100, 50)).thenReturn(200);
		double strikeRate = service.getStrikeRate(50, 25);
		assertEquals(200, strikeRate);
		Mockito.verify(helper).calculateStrikeRate(50, 25);
	}
	
	@Test
	void argumentMatcher() {
		Mockito.when(helper.calculateStrikeRate(Matchers.anyInt(), Matchers.anyInt())).thenReturn(200);
		double strikeRate = service.getStrikeRate(Matchers.anyInt(), Matchers.anyInt());
		assertEquals(200, strikeRate);
		Mockito.verify(helper).calculateStrikeRate(Matchers.anyInt(), Matchers.anyInt());
	}
}
