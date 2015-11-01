package com.margaret;

public class Card {

    private int cardNum;

    final static String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
//    final static String[] suits = {"'\u2060'", "\u2065", "\u2063", "\u2066"};
    final static String[] ranks = {"Ace", "2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King"};


    public Card (){
        this.cardNum = 0;
    }

    // 2060 spade, 2063 club, 2065 heart, 2066 diamond

    // constructor with one arg calls a method with that arg
    public Card (int theCard) {
        if (theCard != -1) {
            setCardNum(theCard);
        }
        else {
            System.out.println("This card has no value.");
        }
    }

//    public void init () {
//
//        System.out.println(COPYRIGHT + " R\u00e9al Gagnon");
//    }

    public void setCardNum (int theCard) {
        if (theCard >= 0 && theCard <= 53){ // for 52 cards, original program had <=52, which was 53 cards, so I changed it to 52
            cardNum = theCard;  // give cardNum the value of ith card in the deck
        }
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

} // end Card class
