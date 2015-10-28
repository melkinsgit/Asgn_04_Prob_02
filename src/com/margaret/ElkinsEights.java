package com.margaret;
import java.util.*;

public class ElkinsEights {

    protected Card inPlay = new Card();

    public static void main(String[] args) {

        LinkedList<Card> temp = new LinkedList<>();  // not used
        Card tempCard;  // doesn't need constructor call because value assigned before var is used
        boolean myTurn; // doesn't need initial value because value assigned before var is used
        int pickPlay;  // doesn't need initial value because value assigned before var is used
        String winner;  // doesn't need initial value because value assigned before var is used
        boolean gameOver;  // doesn't need initial value because value assigned before var is used
        boolean playMore = true;  // true to start loop
        String reply;  // doesn't need initial value because value assigned before var is used
        Scanner c = new Scanner(System.in);

        // welcome the player to the game and ask them to enter their name as they would like it to appear on screen; take in the result as String userName
//        System.out.println("Welcome to Elkins Eights. Enter the name you'd like to use during this game.");
//        String userName = c.nextLine();
        String userName = "Margaret";

        // loop that plays the game more than once if the user Player wants to
        while (playMore) {

            gameOver = false;  // the game isn't over at the beginning
            winner = "";  // there is no winner at the beginning

            // create a deck
            Deck deck = new Deck();

            // shuffle the deck
            deck.shuffle();

            // instantiate a Computer and User, which are subclasses of Player
            Computer compPlay = new Computer("Computer");
            User userPlay = new User(userName);  // give the user the name the user entered at the beginning

            // deal computer and player 7 cards each
            compPlay.setPlayHand(new Hand(deck.dealHand()));
            userPlay.setPlayHand(new Hand(deck.dealHand()));

            // create a pick up pile made of what remains of the deck
            PickUp pickUpPile = new PickUp(Deck.deck);

            // create a discard pile of the top card on the pick up pile
            // there is now one less card in the pick up pile, and one card in the discard pile
            Discard discardPile = new Discard(pickUpPile.getTopCard());

            // until someone wins or we run out of cards in the pick up pile
            while (!gameOver) {
                // start with the user's turn
                myTurn = true;
                // the user and the computer will play until one of them wins

                while (winner.equals("")) {
                    // then the user takes a turn until they win or their turn is over

                    while (myTurn && !userPlay.win) {
                        discardPile.showDiscardPile();
                        // show the user their hand
                        userPlay.showPlayHand();
                        // then call a method that will have the user enter which game action they want, discard or pickup
                        pickPlay = userPlay.chooseMove();

                        switch (pickPlay) {
                            // the user has chosen to discard from their hand
                            case 1: {
                                boolean discarded = false;
                                // call a method to get the card the user wants to discard
                                tempCard = userPlay.cardToDrop();

                                // and until that card is a valid play, ask the user to keep choosing cards
                                while (!discarded) {
                                    if (isValid(tempCard, discardPile)) {  // if the user makes a valid choice
                                        discardPile.addCard(tempCard);  // put that card on the top of the discard pile
                                        System.out.println("Card discarded is " + tempCard);  // confirm the discard for the user
                                        discarded = true;  // then set the flag to exit the loop
                                    } else {  // otherwise, ask the user for another card to discard
                                        System.out.println("Sorry, you can't discard that card. Try again.");
                                        userPlay.showPlayHand();
                                        discardPile.showDiscardPile();
                                        userPlay.addCard(tempCard);  // and put the card they originally discarded, back in their hand.
                                        tempCard = userPlay.cardToDrop();  // call the method to get the card the user wants to discard
                                    }
                                } // end of !discarded loop

                                myTurn = false;  // now the user's turn is over
                                break;  // so break out of the switch statement
                            }

                            case 2: {
                                if (!pickUpPile.moreCards()) {
                                    System.out.println("Out of cards. Game over!");
                                    myTurn = false;
                                    gameOver = true;
                                    break;
                                }

                                tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the pick up pile
//                                System.out.println("the new card from the pick up pile is " + tempCard);
                                userPlay.addCard(tempCard);
                                System.out.println(tempCard + " was added to your hand.");
                                userPlay.showPlayHand();
                                myTurn = false;
                                break;
                            }

                            default: {
                                myTurn = false;
                                break;
                            }

                        } // end switch case

                        // game over can be set to true if there are no more cards in the pick up pile, so make sure the game hasn't ended
                        if (gameOver) break;  // if the game is over break out of the while loop for the user's turn

                        if (!userPlay.moreCards()) {  // and if the user played their last card they won
                            userPlay.setWin(true);  // set the user's boolean to true showing they won
                            System.out.println(userPlay.getPlayName() + " won the game.");  // print a message to the screen
                            winner = userPlay.getPlayName();  // give the winner string a value
                            gameOver = true;  // and set the game over boolean to true showing the game is over
                        }
                    } // end my turn

                    if (userPlay.win) {  // if the user has won, don't give the computer another turn
                        break;
                    }

                    while (!myTurn && !compPlay.win) {

                        discardPile.showDiscardPile();

                        compPlay.showPlayHand();
                        pickPlay = compPlay.chooseMove(discardPile);

                        if (pickPlay == 0) {
                            if (!pickUpPile.moreCards()) {
                                System.out.println("Out of cards. Game over!");
                                myTurn = true;
                                gameOver = true;
                                break;
                            } else {
                                tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the discard pile
                                compPlay.addCard(tempCard);
                                System.out.println("The " + tempCard + " was added to Computer's hand.");
                                compPlay.showPlayHand();
                            }
                        }

                        if (!compPlay.moreCards()) {  // and if the Computer played their last card they won
                            compPlay.setWin(true);  // set the Computer's boolean to true showing they won
                            System.out.println(compPlay.getPlayName() + " won the game.");  // print a message to the screen
                            winner = compPlay.getPlayName();  // give the winner string a value
                            gameOver = true;  // and set the game over boolean to true showing the game is over
                        }
                        myTurn = true;

                        if (gameOver) break;

                        if (!userPlay.win && compPlay.win) {
                            System.out.println(compPlay.getPlayName() + " won the game.");
                            winner = compPlay.getPlayName();
                            gameOver = true;
                        }
                    } // end computer turn
                    if (gameOver) break;
                } // end winner loop
            } // end game over loop

            System.out.println("Want to play another game, " + userPlay.getPlayName() + "? (y or n)");
            reply = c.nextLine();
            if (reply.equals("n") || reply.equals("N")){
                playMore = false;
            }
        }  // end keep playing loop
    } // end main fn

    public static void refreshDiscard(Discard discard, PickUp pickup){
        Card tempCard1;
        System.out.println("The pick up is empty. The discard pile will be recycled as the pick up pile.");
        System.out.println("There are " + discard.getDiscard().size() + " cards in the discard pile. And the top card is: ");
        tempCard1 = discard.getTopCard().pop();  // remove the top card from the discard pile
        System.out.println(tempCard1);
        pickup.setPickUp(discard.getDiscard());  // make the pick up pile what's left of the discard pile
        System.out.println("There are " + pickup.getPickUp().size() + " cards in the pick up pile.");
        Collections.shuffle(pickup.getPickUp());  // shuffle the pick up pile
        System.out.println("The new pick up pile has been shuffled.");
        discard.showDiscardPile();  // this shows the tempCard1 value still in the pile, even though it was popped
        discard.addCard(tempCard1);  // then I push tempCard1 to the discard pile ...
        discard.showDiscardPile();  // ... and now the discard pile shows ONLY the tempCard1
    }  // end refreshDiscard method

    public static boolean isValid (Card card, Discard discard) {
        if (card.getRank().equals(discard.seeTopCard().getRank())) {
            return true;  // add card it to the discard pile
        } else if (card.getSuit().equals(discard.seeTopCard().getSuit())) {
            return true;  // add card to the discard pile
        } else if (card.getRank().equals("8")) {
            return true;  // add card to the discard pile
        }
        return false;
    }  // end isValid method
} // end main class