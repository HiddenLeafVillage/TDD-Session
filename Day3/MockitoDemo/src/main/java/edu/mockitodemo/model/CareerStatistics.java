package edu.mockitodemo.model;

import java.util.UUID;

public class CareerStatistics {
	private UUID id;
	private int matches;
	private int runsScored;
	private double strikeRate;
	private int wickets;
	private int ballsBowled;

	public CareerStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CareerStatistics(UUID id, int matches, int runsScored, double strikeRate, int wickets, int ballsBowled) {
		super();
		this.id = id;
		this.matches = matches;
		this.runsScored = runsScored;
		this.strikeRate = strikeRate;
		this.wickets = wickets;
		this.ballsBowled = ballsBowled;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getBallsBowled() {
		return ballsBowled;
	}

	public void setBallsBowled(int ballsBowled) {
		this.ballsBowled = ballsBowled;
	}

	@Override
	public String toString() {
		return "CareerStatics [id=" + id + ", matches=" + matches + ", runsScored=" + runsScored + ", strikeRate="
				+ strikeRate + ", wickets=" + wickets + ", ballsBowled=" + ballsBowled + "]";
	}

}
