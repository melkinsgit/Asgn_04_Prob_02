package com.margaret;

import java.util.LinkedList;

public class Discard {

    public static LinkedList<Card> discard;

    public Discard (LinkedList<Card> discardPile){
        this.discard = discardPile;
    }

    public void showDiscardPile(){
        if (moreCards()) {
            System.out.println("The top card on the discard pile is: \n\t" + discard.peek());
        }
    }

    public static LinkedList<Card> getDiscard() {
        return discard;
    }

    public static void setDiscard(LinkedList<Card> discard) {
        Discard.discard = discard;
    }

    public boolean moreCards() {
        if (discard.size() > 0){
            return true;
        }
        return false;
    }

    public static Card seeTopCard (){
        return discard.peek();
    }

    public LinkedList<Card> getTopCard(){
        LinkedList<Card> topCardList = new LinkedList<>();
        topCardList.add(discard.pop());
        return topCardList;
    }
}
