package com.margaret;
import java.util.*;

/**
 * Created by Margaret on 10/5/2015. This is the code I got from Stack Overflow: http://stackoverflow.com/questions/24520782/java-shuffle-card-deck. I have edited it and made comments.
 */
public class Deck {

//    private Card[] deck = new Card[52];
    private Stack<Card> deck = new Stack<Card>(); // the Stack Overflow version used an array, but I'm using a stack for a deck of cards; NOTE - I can cast to Vector if there are methods there that could be helpful
    private int topCard;
    final static int DECK_SIZE = 52;

    // constructor - no arg
    public Deck() {

        topCard = 0;

        // for 52 cards, make the value of deck equal to a constructor call to Card with the counter value
        for (int i = 0; i < DECK_SIZE; i++) {
            deck.push(new Card(i));
        }
    }

    public void shuffle() {

        topCard = 0;

        Collections.shuffle(deck);
    }

    public Card dealCard() {
        Card theCard;
        if (topCard < deck.size()) {
            theCard = deck.pop();
            topCard++;
        }
        else
            theCard = null;

        return theCard;
    }
} // end Deck class
