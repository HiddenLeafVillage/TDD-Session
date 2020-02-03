package edu.timetracker.service;

import edu.timetracker.model.RewardStatus;

public class AverageRewardService implements RewardService {

	@Override
	public int prizeReward(int minutes) {
		return minutes * 5;
	}

	@Override
	public RewardStatus getRewardStatus() {
		return RewardStatus.AVERAGE;
	}

}
