package com.margaret;

/**
 * Created by Margaret on 10/5/2015.
 */
public class Card {

    private int cardNum;
    // like a constant TODO understand this
    final static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    final static String[] ranks = {"Ace", "2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King"};

    // constructor with one arg calls a method with that arg
    Card (int theCard) {
        setCardNum (theCard);  // call the setCardNum method
    }

    public void setCardNum (int theCard) {
        if (theCard >= 0 && theCard < 52){ // for 52 cards, original program had <=52, which was 53 cards, so I changed it to 52
            cardNum = theCard;  // give cardNum the value of ith card in the deck
        }
        // I have commented out the else for now; it's an attempt to handle an exception, but it doesn't make sense to me
//        else {
//            cardNum = 0;  // otherwise give cardNum the value 0
//        }
    }

    public int getCardNum() {
        return cardNum;
    }

    // override of parent class toString(), super.toString() the parent
    public String toString() {
        return ranks[cardNum%13] + " of " + suits[cardNum/13];
    }

    // overload of local toString() - I worked on this with Eric Level to learn more about toString
    public String toString(int foo){
        System.out.println("I'm a rogue string with " + foo);
        return "";
    }

    public String getSuit() {
        return suits[cardNum/13];
    }

    public String getRank() {
        return ranks[cardNum%13];
    }

    public int getValue() {
        return cardNum%13;
    }
} // end Card class
