package edu.mockitodemo.model;

import java.util.UUID;

public class Player {
	private UUID id;
	private String name;
	private int age;
	private CareerStatistics careerStatistics;
	private Team team;
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
	public CareerStatistics getCareerStatics() {
		return careerStatistics;
	}
	public void setCareerStatics(CareerStatistics careerStatistics) {
		this.careerStatistics = careerStatistics;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", careerStatistics=" + careerStatistics + ", team="
				+ team + "]";
	}
}
