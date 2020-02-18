package com.adaptionsoft.games.uglytrivia;

public class Place {
    private int place;

    public Place(int place) {

        this.place = place;
    }

    void move(int nbPlaces) {
        place = (place + nbPlaces) % 12;
    }

    public int position() {
        return place;
    }
}
