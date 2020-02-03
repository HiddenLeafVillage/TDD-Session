package edu.timetracker.service;

import static edu.timetracker.persistence.Persistence.timeRecord;
import static java.util.Optional.ofNullable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import edu.timetracker.model.TimeInfo;
import edu.timetracker.model.User;

public class TimeKeeper {
	
	private UserService userService;

	public TimeKeeper(UserService userService) {
		super();
		this.userService = userService;
	}

	public void startAt(UUID id, LocalDateTime start) {
		User user = userService.findUser(id).orElseThrow(NoSuchElementException::new);
		timeRecord.put(id, new TimeInfo(UUID.randomUUID(), start, user));
	}
	
	public void endAt(UUID id, LocalDateTime end) {
		TimeInfo timeInfo = getTimeInfo(id).orElseThrow(NoSuchElementException::new);
		timeInfo.setEndTime(end);
		timeRecord.put(id, timeInfo);
	}
	
	public Optional<TimeInfo> getTimeInfo(UUID id) {
		return ofNullable(timeRecord.get(id));
	}
	
	public RewardService getRewardStatus(UUID id) {
		TimeInfo info = getTimeInfo(id).orElseThrow(NoSuchElementException::new);
		long elapsedTime = info.getStartTime().until(info.getEndTime(), ChronoUnit.MINUTES);
		
		return RewardFacotry.getReward(elapsedTime);
	}
}
