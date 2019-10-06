package com.sweelam.tdd.game;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static junitparams.JUnitParamsRunner.$;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {
	private static final int WINNING_TIMES = 3;
	
	@Test
	public void constructorShouldSetGameWon() {
		FootballTeam team = new FootballTeam(WINNING_TIMES);
		
		assertEquals(3, team.getGameWon());
	}
	
	public Object[] noOfGamesWon() {
		return $(0,1,2);
	}
	
	@Test
	@Parameters(method = "noOfGamesWon")
	public void constructorShouldSetGameWon(int noOfGamesWon) {
		FootballTeam team = new FootballTeam(noOfGamesWon);
		
		assertEquals("Check with different params", noOfGamesWon, team.getGameWon());
	}
	
	public Object[] noOfNonValidGamesWon() {
		return $(-10, -20);
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "noOfNonValidGamesWon")
	public void constructorShouldSetNonValidGameWon(int noOfNonValidGamesWon) {
		FootballTeam team = new FootballTeam(noOfNonValidGamesWon);
		
		assertEquals("Check with different params", noOfNonValidGamesWon, team.getGameWon());
	}
	
	@Test
	public void shouldBePossibleToCompareTeam() {
		FootballTeam team = new FootballTeam(WINNING_TIMES);
		
		assertTrue(team instanceof Comparable);
	}
	
	@Test
	public void teamWithMoreWonShouldBeGreater() {
		FootballTeam team1 = new FootballTeam(2);
		FootballTeam team2 = new FootballTeam(3);
		
		assertTrue(team2.compareTo(team1) > 0);
	}
	
	@Test
	public void teamWithSameWonShouldBeEqual() {
		FootballTeam team1 = new FootballTeam(2);
		FootballTeam team2 = new FootballTeam(2);
		
		assertTrue(team2.compareTo(team1) == 0);
	}
	
	

}
