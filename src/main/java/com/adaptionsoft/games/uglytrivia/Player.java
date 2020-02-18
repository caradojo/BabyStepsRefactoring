package com.adaptionsoft.games.uglytrivia;

public class Player {

    private String playerName;
    private Place place = new Place(0);

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String name() {
        return playerName;
    }

    public Place place() {
        return place;
    }
}
