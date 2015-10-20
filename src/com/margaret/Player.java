package com.margaret;

import java.util.ArrayList;

public class Player {
    private Hand playHand;
    private String playName;

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

    public Player (ArrayList<Card> hand){
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
        System.out.println("The " + playName + " hand is:");
        for (Card card : playHand.getCards()){
            System.out.println(card);
        }
    }

}
