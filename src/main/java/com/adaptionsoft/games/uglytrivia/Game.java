package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private static final int NB_MAX_PLAYERS = 6;
    ArrayList<Player> players = new ArrayList();
    ArrayList<Place> places = new ArrayList();
    int[] purses = new int[NB_MAX_PLAYERS];
    boolean[] inPenaltyBox = new boolean[NB_MAX_PLAYERS];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public void add(String playerName) {
        players.add(new Player(playerName));
        places.add(new Place(0));

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    public void roll(int roll) {
        System.out.println(currentPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (canPlay(roll)) {
            currentPlayerPlay(roll);
        }
    }

    private String currentPlayerName() {
        return players.get(currentPlayer).name();
    }

    private boolean canPlay(int roll) {
        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 == 0) {
                isGettingOutOfPenaltyBox = false;
                System.out.println(currentPlayerName() + " is not getting out of the penalty box");
                return false;

            } else {
                isGettingOutOfPenaltyBox = true;
                System.out.println(currentPlayerName() + " is getting out of the penalty box");
            }
        }
        return true;
    }

    private void currentPlayerPlay(int roll) {
        movePlayer(roll);
        askQuestion();
    }

    private void movePlayer(int roll) {
        moveCurrentPlayer(roll);

        System.out.println(currentPlayerName()
                + "'s new location is "
                + currentPlayerPlace());
        System.out.println("The category is " + currentCategory());
    }

    private void moveCurrentPlayer(int nbPlaces) {
        Place place = places.get(currentPlayer);
        place.move(nbPlaces);
    }

    private int currentPlayerPlace() {
        return places.get(currentPlayer).place();
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }


    private String currentCategory() {
        if (currentPlayerPlace() == 0) return "Pop";
        if (currentPlayerPlace() == 4) return "Pop";
        if (currentPlayerPlace() == 8) return "Pop";
        if (currentPlayerPlace() == 1) return "Science";
        if (currentPlayerPlace() == 5) return "Science";
        if (currentPlayerPlace() == 9) return "Science";
        if (currentPlayerPlace() == 2) return "Sports";
        if (currentPlayerPlace() == 6) return "Sports";
        if (currentPlayerPlace() == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                purses[currentPlayer]++;
                System.out.println(currentPlayerName()
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                return didPlayerWin();
            } else {
                return false;
            }
        } else {
            System.out.println("Answer was corrent!!!!");
            purses[currentPlayer]++;
            System.out.println(currentPlayerName()
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            return didPlayerWin();
        }
    }

    public void wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayerName() + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;
    }

    public void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    private boolean didPlayerWin() {
        return (purses[currentPlayer] == 6);
    }
}
