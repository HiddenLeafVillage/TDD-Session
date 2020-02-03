package edu.timetracker.service;

import edu.timetracker.model.RewardStatus;

public class EndurerRewardService implements RewardService {

	@Override
	public int prizeReward(int minutes) {
		return minutes * 8;
	}

	@Override
	public RewardStatus getRewardStatus() {
		return RewardStatus.ENDURER;
	}

}
