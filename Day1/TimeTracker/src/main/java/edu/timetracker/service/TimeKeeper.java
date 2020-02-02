package edu.timetracker.service;

import static edu.timetracker.persistence.Persistence.timeRecord;
import static edu.timetracker.persistence.Persistence.users;
import static java.util.Optional.ofNullable;
import static edu.timetracker.model.RewardStatus.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import edu.timetracker.model.RewardStatus;
import edu.timetracker.model.TimeInfo;
import edu.timetracker.model.User;

public class TimeKeeper {
	public void startAt(UUID id, LocalDateTime start) {
		User user = findUser(id).orElseThrow(NoSuchElementException::new);
		timeRecord.put(id, new TimeInfo(UUID.randomUUID(), start, user));
	}
	
	public void endAt(UUID id, LocalDateTime end) {
		TimeInfo timeInfo = getTimeInfo(id).orElseThrow(NoSuchElementException::new);
		timeInfo.setEndTime(end);
		timeRecord.put(id, timeInfo);
	}
	
	public Optional<User> findUser(UUID id) {
		return users.stream()
				.filter(x -> x.getId().equals(id))
				.findAny();
	}
	
	public Optional<TimeInfo> getTimeInfo(UUID id) {
		return ofNullable(timeRecord.get(id));
	}
	
	public RewardStatus getReward(UUID id) {
		TimeInfo info = getTimeInfo(id).orElseThrow(NoSuchElementException::new);
		long elapsedTime = info.getStartTime().until(info.getEndTime(), ChronoUnit.MINUTES);
		
		if(elapsedTime >= 180) {
			return MARATHONER;
		}
		else if(elapsedTime >= 60) {
			return ENDURER;
		}
		else if(elapsedTime >= 30) {
			return AVERAGE;
		}
		else {
			return WEAKLING;
		}
	}
}
