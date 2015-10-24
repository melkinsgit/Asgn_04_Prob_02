package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by sn0173nd on 10/19/2015.
 */
public class Computer extends Player {

    public Computer(String name) {
        super(name);
    }

    public int chooseMove (Discard discard, PickUp pickUp){

//        int choice = 0;
        Card tempCard;
//        LinkedList<Card> dropCard = new LinkedList<>();
//        boolean valid = false;
//        String choiceStr = "";
//        Scanner scan = new Scanner(System.in);
//        System.out.println("What would you like to do?\n\t1. Play a card to the discard pile.\n\t2. Pick up a card.\n\t3. Pass.");
//        choiceStr = scan.nextLine();
        int i = 0;

        for (Card card : playHand.getCards()) {
//            System.out.println("the rank of the card from the hand is " + card.getRank() + " and the rank of the discard top card is " + discard.seeTopCard().getRank());
//            System.out.println("the suit of the card from the hand is " + card.getSuit() + " and the suit of the discard top card is " + discard.seeTopCard().getSuit());
//            discard.showDiscardPile();
            if (card.getRank() == discard.seeTopCard().getRank()) {
//                tempCard = userPlay.cardToDrop().pop();  // get the card the user wants to drop
                discard.getDiscard().push(card);  // add card it to the discard pile
                playHand.getCards().remove(i);
                return 5;
            } else if (card.getSuit() == discard.seeTopCard().getSuit()) {
                discard.getDiscard().push(card);  // add card to the discard pile
                playHand.getCards().remove(i);
                return 5;
            } else if (card.getRank().equals("8")) {
                discard.getDiscard().push(card);  // add card to the discard pile
                playHand.getCards().remove(i);
                return 5;
            }
            i++;
        }
        return 0;

    }


    public LinkedList<Card> cardToDrop (){
        int choice = 0;
        LinkedList<Card> dropCard = new LinkedList<>();
        boolean valid = false;
        String choiceStr = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Which card would you like to discard?");
        choiceStr = scan.nextLine();

        while (!valid) {
            try {
                choice = Integer.parseInt(choiceStr);
                if (choice >= 1 && choice <= this.playHand.getSize()) {
                    valid = true;
                } else {
                    System.out.println("Sorry, that's not a valid choice. Please try again.");
                    choiceStr = scan.nextLine();
                }
            } catch (Exception ex) {
                System.out.println("Sorry, that's not a valid choice. Please try again.");
                choiceStr = scan.nextLine();
            }
        }

        System.out.println("Card dropped is " + this.playHand.getCards().get(choice - 1));
        dropCard.add(this.playHand.getCards().get(choice - 1));
        playHand.getCards().remove(choice-1);
        return dropCard;
    }

    public void addCard (Card c){
        playHand.getCards().push(c);
    }
}
