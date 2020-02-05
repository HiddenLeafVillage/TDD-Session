package edu.mockitodemo.argumentmatchers;

import org.mockito.ArgumentMatcher;

import edu.mockitodemo.model.Player;

public class PlayerMatcher implements ArgumentMatcher<Player> {
	private Player player;

	public PlayerMatcher(Player player) {
		super();
		this.player = player;
	}

	@Override
	public boolean matches(Player argument) {
		return player.equals(argument);
	}

}
