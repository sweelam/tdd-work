package com.sweelam.tdd.game;

public class FootballTeam implements Comparable<FootballTeam>{
	private int winningTimes;
	private static final String WINNING_TIMES_RANGE = 
			"number of game wons cannot be less than zero";
	
	public FootballTeam(int winningTimes) throws IllegalArgumentException {
		if (winningTimes < 0)
			throw new IllegalArgumentException(WINNING_TIMES_RANGE);
		this.winningTimes = winningTimes;
	}

	public int getGameWon() {
		return winningTimes;
	}

	public int compareTo(FootballTeam otherTeam) {
		return this.winningTimes - otherTeam.winningTimes;
	}

}
