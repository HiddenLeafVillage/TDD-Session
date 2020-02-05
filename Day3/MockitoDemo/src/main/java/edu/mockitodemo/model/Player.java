package edu.mockitodemo.model;

import java.util.Objects;
import java.util.UUID;

public class Player {
	private UUID id;
	private String name;
	private int age;
	private CareerStatistics careerStatistics;
	private Team team;
	private boolean isActive;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(UUID id, String name, int age, CareerStatistics careerStatistics, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.careerStatistics = careerStatistics;
		this.team = team;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public CareerStatistics getCareerStatistics() {
		return careerStatistics;
	}

	public void setCareerStatistics(CareerStatistics careerStatistics) {
		this.careerStatistics = careerStatistics;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, careerStatistics, id, isActive, name, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return age == other.age && Objects.equals(careerStatistics, other.careerStatistics)
				&& Objects.equals(id, other.id) && isActive == other.isActive && Objects.equals(name, other.name)
				&& Objects.equals(team, other.team);
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", careerStatistics=" + careerStatistics
				+ ", team=" + team + ", isActive=" + isActive + "]";
	}

}
