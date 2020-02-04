package edu.mockitodemo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.mockitodemo.model.Player;

public interface PlayerRepository {
	public Optional<Player> findById(UUID id);
	public Optional<Player> findByName(String name);
	public Player getByName(String name);
	public List<Player> findByTeam(String name);
	public void save(Player player);
}
