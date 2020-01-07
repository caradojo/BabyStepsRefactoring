package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunner {

	public static void main(String[] args) {
		Random rand = new Random();
		playGame(rand);
	}

	public static void playGame(Random randomizer) {
		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		boolean playerWon = false;

		do {

			aGame.roll(randomizer.nextInt(5) + 1);

			if (randomizer.nextInt(9) == 7) {
				aGame.wrongAnswer();
			} else {
				playerWon = aGame.wasCorrectlyAnswered();
			}

			aGame.nextPlayer();
		} while (!playerWon);
	}
}
