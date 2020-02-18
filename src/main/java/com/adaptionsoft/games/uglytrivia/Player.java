package com.adaptionsoft.games.uglytrivia;

public class Player {

    private String name;
    private Place place = new Place(0);

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    void move(int nbPlaces) {
        place.move(nbPlaces);
    }

    int position() {
        return place.position();
    }
}
