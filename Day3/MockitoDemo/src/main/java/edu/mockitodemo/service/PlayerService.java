package edu.mockitodemo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import edu.mockitodemo.model.Player;
import edu.mockitodemo.repository.PlayerRepository;
import edu.mockitodemo.repository.PlayerRepositoryImplementation;

public class PlayerService {
	private PlayerRepository repository;
	
	private PlayerRepositoryImplementation repoImpl;

	public Player getPlayer(UUID id) {
		return repository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	public Player getPlayer(String name) {
		return repository.findByName(name).orElseThrow(NoSuchElementException::new);
	}
	
	public Player getPlayerOrThrow(String name) {
		return repository.getByName(name);
	}
	
	public Player getRealPlayer(String name) {
		return repoImpl.getByName(name);
	}
	
	public void savePlayer(Player player) {
		repository.save(player);
	}
	
	public List<Player> getPlayers(String team) {
		return repository.findByTeam(team);
	}
	
	public String getName() {
		return repoImpl.getName() + repoImpl.getName();
	}
	
	public void save(Player player) {
		player.setActive(true);
		repository.save(player);
	}
}
