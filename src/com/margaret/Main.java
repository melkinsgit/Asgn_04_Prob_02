package com.margaret;

public class Main {

    public static void main(String[] args) {

    Deck deck = new Deck();
    deck.shuffle();
    Card dealt = deck.dealCard();
    System.out.println(dealt);

    } // end main fn
} // end main class