package com.margaret;

import java.util.Scanner;

public class User extends Player {

    // constructor - just sets the playName per the super class Player
    public User(String name) {
        super(name);
    }

    // this method asks the user which card they want to drop and returns that card object
    public Card cardToDrop() {
        int choice = 0;
        Card dropCard;
        boolean valid = false;
        String choiceStr = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Which card would you like to discard?");
        choiceStr = scan.nextLine();

        // TODO what if they try all their cards and they don't have any that will play?
        while (!valid) {
            try {
                choice = Integer.parseInt(choiceStr);
                if (choice >= 1 && choice <= this.playHand.getSize()) {
                    valid = true;
                } else {
                    System.out.println("Sorry, that's not a valid choice from hand. Please try again.");
                    choiceStr = scan.nextLine();
                }
            } catch (Exception ex) {
                System.out.println("Sorry, that's not a valid choice another exception. Please try again.");
                choiceStr = scan.nextLine();
            }
        }
        dropCard = playHand.getCards().remove(choice - 1);
        return dropCard;  // this is the card that will be dropped
    }

    public int chooseMove() {

        int choice = 0;
        boolean valid = false;
        String choiceStr = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to do?\n\t1. Play a card to the discard pile.\n\t2. Pick up a card.");
        choiceStr = scan.nextLine();

        while (!valid) {
            try {
                choice = Integer.parseInt(choiceStr);
                if (choice >= 1 && choice <= 2) {
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
        return choice;
    }

    public void addCard(Card c) {
        playHand.getCards().push(c);
    }

    // this method tests whether or not the user's chosen card can be discarded
    public boolean isValid(Card card, Discard discard) {

        if (card.getRank().equals("8")) {  // if it's an 8
            return true;  // add card to the discard pile
        } else if (card.getSuit().equals(discard.seeTopCard().getSuit())) { // if its suit matches the suit of the card on the discard pile
            return true;  // add card to the discard pile
        } else if (card.getRank().equals(discard.seeTopCard().getRank())) { // if its rank matches the rank of the card on the discard pile
            return true;  // add card it to the discard pile
        }
        return false;  // otherwise, they can't put this card on the discard pile
    }  // end isValid method

    public boolean userTurn(Discard discardPile, PickUp pickUpPile) {

        Card tempCard;
        int pickPlay;
        boolean gameOver = false;


        // show them the top card on the discard pile
        discardPile.showDiscardPile();
        // show the user their hand
        showPlayHand();

        // then call a method that will have the user enter which game action they want, discard or pickup
        pickPlay = chooseMove();

        if (pickPlay == 1) {
            // the user has chosen to discard from their hand

            boolean discarded = false;
            // call a method to get the card the user wants to discard
            tempCard = cardToDrop();  // get a card to test for being valid on the discard pile

            // and until that card is a valid play, ask the user to keep choosing cards
            while (!discarded) {
                if (isValid(tempCard, discardPile)) {  // if the user has made a valid choice
                    discardPile.addCard(tempCard);  // put that card on the top of the discard pile
                    System.out.println(this.playName + " discarded the " + tempCard);  // confirm the discard for the user
                    discarded = true;  // then set the flag to exit the loop
                } else {  // otherwise, ask the user for another card to discard
                    System.out.println("Sorry, you can't discard that card. Try again.");
                    this.addCard(tempCard);  // and put the card they originally discarded, back in their hand.
                    showPlayHand();  // remind the user of their hand the discard pile so they can choose another card
                    discardPile.showDiscardPile();
                    tempCard = cardToDrop();  // call the method to get the card the user wants to discard
                }
            } // end of !discarded loop
        }

        if (pickPlay == 2) {
            // the user has chosen to pick a card from the pick up pile

            if (!pickUpPile.moreCards()) {  // if there no more cards in the pick up pile
                if (discardPile.getDiscard().size() < 2) {  // and if there aren't enough in the discard pile to create a new pick up pile, the game is over
                    System.out.println("There are no cards in play. Game over.");
                    gameOver = true;
                    return gameOver;
                } else {
                    ElkinsEights.refreshDiscard(discardPile, pickUpPile);  // if there are enough cards in the discard pile, refresh the deck
                }
            }

            // once there is a working pick up pile the user can draw a card
            tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the pick up pile
            addCard(tempCard);
            System.out.println(tempCard + " was added to your hand.");
            showPlayHand();
        }

        // game over can be set to true if there are no more cards in the pick up pile, so make sure the game hasn't ended
        if (!gameOver && !this.moreCards()) {  // and if the user played their last card they won
            this.setWin(true);  // set the user's boolean to true showing they won
            System.out.println(this.getPlayName() + " won the game.");  // print a message to the screen
            gameOver = true;  // and set the game over boolean to true showing the game is over
        }
        return gameOver;
    }
}

