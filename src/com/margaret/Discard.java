package com.margaret;

import java.util.LinkedList;

public class Discard {

    static LinkedList<Card> discard;

    public Discard (LinkedList<Card> discardPile){
        this.discard = discardPile;
    }

    public void showDiscardPile(){
        if (moreCards()) {
            System.out.println("The top card on the pick up pile is: " + discard.peek());
        }
    }

    public static LinkedList<Card> getDiscard() {
        return discard;
    }

    public boolean moreCards() {
        if (discard.size() > 0){
            return true;
        }
        return false;
    }

    public Card seeTopCard (){
        return discard.peek();
    }

    public LinkedList<Card> getTopCard(){
        LinkedList<Card> topCardList = new LinkedList<>();
        topCardList.add(discard.pop());
        return topCardList;
    }
}
