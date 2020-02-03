package edu.timetracker.service;

import edu.timetracker.model.RewardStatus;

public class WeaklingRewardService implements RewardService {

	@Override
	public int prizeReward(int minutes) {
		return 0;
	}

	@Override
	public RewardStatus getRewardStatus() {
		return RewardStatus.WEAKLING;
	}

}
