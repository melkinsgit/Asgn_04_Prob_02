package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
    protected Hand playHand;
    protected String playName;

    public Player (){
        this.playHand = new Hand();
        this.playName = "";
    }

    public Player (String name){
        this.playName = name;
        this.playHand = new Hand();
    }

    public Player (Hand hand) {
        this.playHand = hand;
    }

    public Player (LinkedList<Card> hand){
        this.playHand = new Hand(hand);
    }

    public Player(Hand playHand, String playName) {
        this.playHand = playHand;
        this.playName = playName;
    }

    public Hand getPlayHand() {
        return playHand;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayHand(Hand playHand) {
        this.playHand = playHand;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public void showPlayHand(){
        if (moreCards()) {
            System.out.println(playName + "'s hand is:");
            for (Card card : playHand.getCards()) {
                System.out.println(card);
            }
        }
    }

    public boolean moreCards() {
        if (playHand.getCards().size() > 0) {
            return true;
        } else {
            System.out.println(playName + " has no more cards.");
            return false;
        }
    }

//    public Card playCard(){
//        Card theCard;
//    }
}
