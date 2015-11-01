package com.margaret;

import java.util.LinkedList;

public class Discard {

    public LinkedList<Card> discard;

    // constructor
    public Discard (LinkedList<Card> discardPile){
        this.discard = discardPile;
    }

    public void showDiscardPile(){
        if (moreCards()) {
            System.out.println("The top card on the discard pile is: " + discard.peek());
        }
    }

    public LinkedList<Card> getDiscard() {
        return discard;
    }

    public void setDiscard(LinkedList<Card> discard) {
        this.discard = discard;
    }

    public void setDiscard(int i) {this.discard = new LinkedList<Card>();}

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

    public void addCard (Card c){
        this.getDiscard().push(c);
    }
}
