package edu.mockitodemo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.mockitodemo.helper.CareerStatisticsHelper;
import edu.mockitodemo.model.Player;
import edu.mockitodemo.service.CareerStatisticsService;
import edu.mockitodemo.test.anntations.JsonToPlayer;
import net.joshka.junit.json.params.JsonFileSource;

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
		Mockito.when(helper.calculateStrikeRate(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(200);
		double strikeRate = service.getStrikeRate(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
		assertEquals(200, strikeRate);
		Mockito.verify(helper).calculateStrikeRate(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt());
	}
	
	@Test
	void argumentMatcher2() {
		Mockito.when(helper.calculateStrikeRate(ArgumentMatchers.eq(100), ArgumentMatchers.anyInt())).thenReturn(200);
		double strikeRate = service.getStrikeRate(100, ArgumentMatchers.anyInt());
		assertEquals(200, strikeRate);
		Mockito.verify(helper).calculateStrikeRate(100,ArgumentMatchers.anyInt());
	}
}
