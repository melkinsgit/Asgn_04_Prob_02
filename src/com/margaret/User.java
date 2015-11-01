package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class User extends Player {

    public User(String name) {
        super(name);
    }

    public Card cardToDrop() {
        int choice = 0;
        Card dropCard = new Card();
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
        return dropCard;
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

    public boolean isValid(Card card, Discard discard) {
        int eightSuit;

        if (card.getRank().equals("8")) {
            return true;  // add card to the discard pile
        } else if (card.getSuit().equals(discard.seeTopCard().getSuit())) {
            return true;  // add card to the discard pile
        } else if (card.getRank().equals(discard.seeTopCard().getRank())) {
            return true;  // add card it to the discard pile
        }
        return false;
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
            tempCard = cardToDrop();

            // and until that card is a valid play, ask the user to keep choosing cards
            while (!discarded) {
                if (isValid(tempCard, discardPile)) {  // if the user makes a valid choice
                    discardPile.addCard(tempCard);  // put that card on the top of the discard pile
                    System.out.println(this.playName + " discarded the " + tempCard);  // confirm the discard for the user
                    discarded = true;  // then set the flag to exit the loop
                } else {  // otherwise, ask the user for another card to discard
                    System.out.println("Sorry, you can't discard that card. Try again.");
                    this.addCard(tempCard);  // and put the card they originally discarded, back in their hand.
                    showPlayHand();
                    discardPile.showDiscardPile();
                    tempCard = cardToDrop();  // call the method to get the card the user wants to discard
                }
            } // end of !discarded loop
        }

        if (pickPlay == 2) {
            if (!pickUpPile.moreCards()) {
                if (discardPile.getDiscard().size() < 2) {
                    System.out.println("There are no cards in play. Game over.");
                    gameOver = true;
                    return gameOver;
                } else {
                    ElkinsEights.refreshDiscard(discardPile, pickUpPile);
                }
            }

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

//    public int pickAnEight() {
//        Scanner c = new Scanner(System.in);
//        boolean picked = false;
//        int suitNum;
//        while (!picked) {
//            try {
//                System.out.println("You get to pick a suit:\n\t1. Spades\n" +
//                        "\t2. Hearts\n" +
//                        "\t3. Clubs\n" +
//                        "\t4. Diamonds");
//                suitNum = Integer.parseInt(c.nextLine());
//                picked = true;
//                return suitNum-1;
//            } catch (Exception e) {
//                System.out.println("That choice won't work. Please pick the number of the suit you want to play.");
//            }
//        }
//        return 0;
//    }
}

