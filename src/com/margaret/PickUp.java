package com.margaret;

import java.util.*;

/**
 * Created by Margaret on 10/20/2015.
 */
public class PickUp {
    protected LinkedList<Card> pickUp;

    public PickUp () { this.pickUp = new LinkedList<Card>();}

    public PickUp (LinkedList<Card> pickUpPile) {
        this.pickUp = pickUpPile;
    }

    public LinkedList<Card> getPickUp() {
        return pickUp;
    }

    public void showPickUpPile(){
        System.out.println("The pick up pile is:");
        for (Card card : pickUp){
            System.out.println(card);
        }
    }

    public void setPickUp(LinkedList<Card> pickUp) {
        this.pickUp = pickUp;
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

    public LinkedList<Card> getTopCard(){
        LinkedList<Card> topCardList = new LinkedList<>();
        topCardList.add(pickUp.pop());
        return topCardList;
    }

}
