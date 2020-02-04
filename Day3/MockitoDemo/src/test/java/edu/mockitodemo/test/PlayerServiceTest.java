package edu.mockitodemo.test;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.verification.VerificationMode;

import edu.mockitodemo.exceptions.PlayerNotFoundException;
import edu.mockitodemo.model.CareerStatistics;
import edu.mockitodemo.model.Player;
import edu.mockitodemo.model.Team;
import edu.mockitodemo.repository.PlayerRepository;
import edu.mockitodemo.repository.PlayerRepositoryImplementation;
import edu.mockitodemo.service.PlayerService;
import edu.mockitodemo.test.anntations.JsonToPlayer;
import net.joshka.junit.json.params.JsonFileSource;

public class PlayerServiceTest {
	
	@Mock
	PlayerRepository repository;
	
	@Mock
	PlayerRepositoryImplementation repoImpl;
	
	@InjectMocks
	PlayerService service;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void test() {
		CareerStatistics statistics = new CareerStatistics(UUID.randomUUID(), 100, 8000, 120, 1, 10);
		Team team = new Team(UUID.randomUUID(), "CSK");
		Player player = new Player(UUID.randomUUID(), "Dhoni", 30, statistics, team);
		Mockito.when(repository.findByName("Dhoni")).thenReturn(of(player));
		Player retrivedPlayer = service.getPlayer("Dhoni");
		Mockito.verify(repository).findByName("Dhoni");
		assertEquals(player, retrivedPlayer);
	}
	
	@ParameterizedTest
    @JsonFileSource(resources = "/player.json")
	void testThenReturn(@JsonToPlayer Player player) {
		Mockito.when(repository.findByName("Dhoni")).thenReturn(of(player));
		Player retrivedPlayer = service.getPlayer("Dhoni");
		Mockito.verify(repository).findByName("Dhoni");
		assertEquals(player, retrivedPlayer);
	}
	
	@ParameterizedTest
    @JsonFileSource(resources = "/player.json")
	void testThrowException(@JsonToPlayer Player player) {
		Mockito.when(repository.getByName("Virat")).thenThrow(new PlayerNotFoundException(""));
		Assertions.assertThrows(PlayerNotFoundException.class, () -> service.getPlayerOrThrow("Virat"));
		Mockito.verify(repository).getByName("Virat");
	}
	
	@Test
	void testThenCallRealMethod() {
		Mockito.when(repoImpl.getByName("Dhoni")).thenCallRealMethod();
		Player retrivedPlayer = service.getRealPlayer("Dhoni");
		Mockito.verify(repoImpl).getByName("Dhoni");
		assertNotNull(retrivedPlayer);
	}
	
	@Test
	void testThenAnswer() {
		Mockito.when(repoImpl.getByName("Dhoni")).thenAnswer(x -> new Player());
		Player retrivedPlayer = service.getRealPlayer("Dhoni");
		Mockito.verify(repoImpl).getByName("Dhoni");
		assertNotNull(retrivedPlayer);
	}
	
	@ParameterizedTest
    @JsonFileSource(resources = "/player.json")
	void testVoidMethod(@JsonToPlayer Player player) {
		Mockito.doNothing().when(repository).save(player);
		service.savePlayer(player);
		Mockito.verify(repository).save(player);
	}
	
	@ParameterizedTest
    @JsonFileSource(resources = "/player.json")
	void testThenReturnVerification(@JsonToPlayer Player player) {
		Mockito.when(repository.findByName("Dhoni")).thenReturn(of(player));
		Player retrivedPlayer = service.getPlayer("Dhoni");
		Mockito.verify(repository, VerificationModeFactory.atLeastOnce()).findByName("Dhoni");
		assertEquals(player, retrivedPlayer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
