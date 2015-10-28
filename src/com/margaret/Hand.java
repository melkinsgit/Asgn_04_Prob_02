package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;


public class Hand {
    private LinkedList<Card> cards;

    public Hand(){
        cards = new LinkedList<>();
    }

    public Hand (LinkedList<Card> hand) {
        this.cards = hand;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public int getSize(){
        return cards.size();
    }
}
