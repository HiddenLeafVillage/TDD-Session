package edu.timetracker.service;

public class RewardFacotry {
	public static RewardService getReward(long elapsedTime) {
		if(elapsedTime >= 180) {
			return new MarathonerRewardService();
		}
		else if(elapsedTime >= 60) {
			return new EndurerRewardService();
		}
		else if(elapsedTime >= 30) {
			return new AverageRewardService();
		}
		else {
			return new WeaklingRewardService();
		}
	}
}
