package edu.mockitodemo.helper;

public class CareerStatisticsHelper {
	
	public int calculateStrikeRate(int runsScored, int ballsFaced) {
		return runsScored/ballsFaced * 100;
	}
	
	public int calculateStrikeRate(int runsScored, int ballsFaced, String dummy) {
		return runsScored/ballsFaced * 100;
	}
}
