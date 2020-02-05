package edu.mockitodemo.model;

import java.util.Objects;
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
	public int hashCode() {
		return Objects.hash(ballsBowled, id, matches, runsScored, strikeRate, wickets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CareerStatistics other = (CareerStatistics) obj;
		return ballsBowled == other.ballsBowled && Objects.equals(id, other.id) && matches == other.matches
				&& runsScored == other.runsScored
				&& Double.doubleToLongBits(strikeRate) == Double.doubleToLongBits(other.strikeRate)
				&& wickets == other.wickets;
	}

	@Override
	public String toString() {
		return "CareerStatics [id=" + id + ", matches=" + matches + ", runsScored=" + runsScored + ", strikeRate="
				+ strikeRate + ", wickets=" + wickets + ", ballsBowled=" + ballsBowled + "]";
	}

}
