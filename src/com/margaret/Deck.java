package com.margaret;
import java.util.*;

public class Deck {

    static LinkedList<Card> deck = new LinkedList<>();
    final static int DECK_SIZE = 52;

    // constructor - no arg
    public Deck() {
        for (int i = 0; i < DECK_SIZE; i++) {
            deck.push(new Card(i));
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
            Card theCard = deck.pop();
            return theCard;
    }

    public LinkedList<Card> dealHand (){
        LinkedList<Card> hand = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            hand.add(dealCard());
        }
        return hand;
    }

    public boolean moreCards() {
        if (deck.size() > 0){
            return true;
        }
        return false;
    }
} // end Deck class
