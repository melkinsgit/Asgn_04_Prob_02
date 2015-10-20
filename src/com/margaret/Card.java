package com.margaret;

/**
 * Created by Margaret on 10/5/2015.
 */
public class Card {

    private int cardNum;
//    private String cardRank;
//    private String cardSuit;

    final static String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
    final static String[] ranks = {"Ace", "2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King"};

    public Card (){
        this.cardNum = 0;
    }

    // constructor with one arg calls a method with that arg
    public Card (int theCard) {
        if (theCard != -1) {
            setCardNum(theCard);
        }
        else {
            System.out.println("This card has no value.");
        }
//        cardRank = ranks[cardNum%13];
//        cardSuit = suits[cardNum/13];
    }

    public void setCardNum (int theCard) {
        if (theCard >= 0 && theCard <= 53){ // for 52 cards, original program had <=52, which was 53 cards, so I changed it to 52
            cardNum = theCard;  // give cardNum the value of ith card in the deck
        }
    }

    public int getCardNum() {
        return cardNum;
    }

    public int getCardVal(Card card){
        return 0;
    }

    // override of parent class toString(), super.toString() the parent
    public String toString() {
        return ranks[cardNum%13] + " of " + suits[cardNum/13];
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
