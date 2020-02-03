package edu.timetracker.service;

import edu.timetracker.model.RewardStatus;

public interface RewardService {
	public int prizeReward(int minutes);
	public RewardStatus getRewardStatus();
}
