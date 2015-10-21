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

    public static LinkedList<Card> getPickUp() {
        return pickUp;
    }

    public static void setPickUp(LinkedList<Card> pickUp) {
        PickUp.pickUp = pickUp;
    }

    public boolean moreCards() {
        if (pickUp.size() > 0) {
            return true;
        }
        else {
            System.out.println("The pickup pile is empty.");
            return false;
        }
    }

    public void showPickUpPile(){
        if (moreCards()) {
            System.out.println("The top card on the pick up pile is: " + pickUp.peek());
        }
    }
}
