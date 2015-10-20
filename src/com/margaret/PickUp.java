package com.margaret;

import java.util.LinkedList;

/**
 * Created by Margaret on 10/20/2015.
 */
public class PickUp {
    static LinkedList<Card> pickUp;

    public PickUp (LinkedList<Card> pickUpPile) {
        this.pickUp = pickUpPile;
    }

    public void showPickUpPile(){
        for (Card card : pickUp){
            System.out.println("The pick up pile is:");
            System.out.println(card);
        }
    }
}
