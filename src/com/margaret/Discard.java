package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;

public class Discard {

    static LinkedList<Card> discard;

    public Discard (LinkedList<Card> discardPile){
        this.discard = discardPile;
    }

    public void showDiscardPile(){
        System.out.println("The discard pile is:");
        for (Card card : discard){
            System.out.println(card);
        }
    }

    public boolean moreCards() {
        if (discard.size() > 0){
            return true;
        }
        return false;
    }

    public LinkedList<Card> getTopCard(){
        LinkedList<Card> topCardList = new LinkedList<>();
        topCardList.add(discard.pop());
        return topCardList;
    }
}
