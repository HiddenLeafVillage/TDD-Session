package edu.timetracker.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class TimeInfo {
	private UUID id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private User user;

	public TimeInfo(UUID id, LocalDateTime startTime, User user) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.user = user;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endTime, id, startTime, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeInfo other = (TimeInfo) obj;
		return Objects.equals(endTime, other.endTime) && Objects.equals(id, other.id)
				&& Objects.equals(startTime, other.startTime) && Objects.equals(user, other.user);
	}

	
}
