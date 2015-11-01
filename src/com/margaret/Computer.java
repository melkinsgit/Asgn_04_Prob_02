package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Computer extends Player {

    public Computer(String name) {
        super(name);
    }

    public int chooseMove (Discard discard){
        Random rnd = new Random();
        int rndSuit;
        rndSuit = rnd.nextInt(4);
        int i = 0;

        for (Card card : playHand.getCards()) {
            if (card.getSuit().equals(discard.seeTopCard().getSuit())) {
                discard.getDiscard().push(card);  // add card it to the discard pile
                playHand.getCards().remove(i);
                System.out.println(this.playName + " discarded the " + card);  // confirm the discard for the user
                return 5;
            }
            i++;
        }
        i = 0;
        for (Card card : playHand.getCards()) {
            if (card.getRank().equals(discard.seeTopCard().getRank())){
                discard.getDiscard().push(card);  // add card it to the discard pile
                playHand.getCards().remove(i);
                System.out.println(this.playName + " discarded the " + card);  // confirm the discard for the user
                return 5;
            }
            i++;
        }
        i = 0;
        for (Card card : playHand.getCards()) {
            if (card.getRank().equals("8")){
                discard.getDiscard().push(card);  // add card it to the discard pile
                playHand.getCards().remove(i);
                System.out.println(this.playName + " discarded the " + card);  // confirm the discard for the user
                return 5;
            }
            i++;
        }
        return 0;
    }

    public boolean compTurn (Discard discardPile, PickUp pickUpPile) {
        int pickPlay;
        boolean gameOver = false;
        Card tempCard;

//        discardPile.showDiscardPile();
//        this.showPlayHand();
        pickPlay = this.chooseMove(discardPile);

        if (pickPlay == 0) {
            System.out.println("The computer has chosen to pick up a card.");
            if (!pickUpPile.moreCards()) {
                if (discardPile.getDiscard().size() < 2) {
                    System.out.println("There are no cards in play. Game over.");
//                    discardPile.showDiscardPile();
//                    pickUpPile.showPickUpPile();
                    gameOver = true;
                    return gameOver;
                } else {
                    ElkinsEights.refreshDiscard(discardPile, pickUpPile);
                }
            }
            tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the discard pile
            this.addCard(tempCard);
            System.out.println("A card was added to Computer's hand.");
//                this.showPlayHand();
        }
        if (!gameOver && !this.moreCards()) {  // and if the user played their last card they won
            this.setWin(true);  // set the user's boolean to true showing they won
            System.out.println(this.getPlayName() + " won the game.");  // print a message to the screen
            gameOver = true;  // and set the game over boolean to true showing the game is over
        }
        return gameOver;
    }

    public void addCard (Card c){
        playHand.getCards().push(c);
    }
}
