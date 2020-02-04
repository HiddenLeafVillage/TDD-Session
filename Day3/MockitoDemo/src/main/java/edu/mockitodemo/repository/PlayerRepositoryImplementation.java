package edu.mockitodemo.repository;

import edu.mockitodemo.model.Player;

public class PlayerRepositoryImplementation {
	public Player getByName(String name) {
		System.out.println("Invoking Real Method");
		return new Player();
	}
}
