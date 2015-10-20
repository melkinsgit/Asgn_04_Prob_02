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

    public static LinkedList<Card> getDeck() {
        return deck;
    }

    public static void setDeck(LinkedList<Card> deck) {
        Deck.deck = deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
            Card theCard = deck.pop();
            return theCard;
    }

    public ArrayList<Card> dealHand (){
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            hand.add(dealCard());
        }
        return hand;
    }

    public void showDeck (){
        System.out.println("The deck is:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    /**
     * As cards are dealt from the deck, the number of
     * cards left decreases.  This function returns the
     * number of cards that are still left in the deck.
     */
    public int cardsLeft(){
        return 0;
    }

    public boolean moreCards() {
        if (deck.size() > 0){
            return true;
        }
        return false;
    }
} // end Deck class
