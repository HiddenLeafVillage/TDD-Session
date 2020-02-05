package edu.mockitodemo.model;

import java.util.Objects;
import java.util.UUID;

public class Team {
	private UUID id;
	private String teamName;

	public Team() {
		super();
	}

	public Team(UUID id, String teamName) {
		super();
		this.id = id;
		this.teamName = teamName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, teamName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(id, other.id) && Objects.equals(teamName, other.teamName);
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + "]";
	}

}
