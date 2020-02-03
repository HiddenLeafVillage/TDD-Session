package edu.timetracker.service;

import edu.timetracker.model.RewardStatus;

public class MarathonerRewardService implements RewardService {

	@Override
	public int prizeReward(int minutes) {
		return minutes * 10;
	}

	@Override
	public RewardStatus getRewardStatus() {
		return RewardStatus.MARATHONER;
	}

}
