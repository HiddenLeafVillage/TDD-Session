package edu.mockitodemo.service;

import edu.mockitodemo.helper.CareerStatisticsHelper;

public class CareerStatisticsService {

	CareerStatisticsHelper helper;
	
	public int getStrikeRate(int runsScored, int ballsFaced) {
		return helper.calculateStrikeRate(runsScored, ballsFaced);
	}
}
