package com.margaret;
import java.util.*;

public class ElkinsEights {

    public static void main(String[] args) {

        LinkedList<Card> temp = new LinkedList<>();
        Card tempCard = new Card();
        boolean myTurn = false;
        int pickPlay = 0;

        // TODO while you still want to play
        // create a deck
        Deck deck = new Deck();

        // shuffle deck
        deck.shuffle();

        // welcome the player to the game and ask them to enter their name as they would like it to appear on screen; take in the result as String userName
        String userName = "Margaret";

        Computer compPlay = new Computer("Computer");
        User userPlay = new User(userName);

        // deal computer and player 7 cards each
        compPlay.setPlayHand(new Hand(deck.dealHand()));
        userPlay.setPlayHand(new Hand(deck.dealHand()));

//        userPlay.showPlayHand();

//        Discard discardPile = new Discard(deck.getDeck());
        PickUp pickUpPile = new PickUp(deck.getDeck());
//        PickUp pickUpPile = new PickUp(discardPile.getTopCard());
        Discard discardPile = new Discard(pickUpPile.getTopCard());
        discardPile.showDiscardPile();

        // TODO while there is no winner

        myTurn = true;

        // while it's my turn
        while (myTurn) {

        userPlay.showPlayHand();
        pickPlay = userPlay.chooseMove();

        switch (pickPlay) {
            case 1:{

//            temp = userPlay.Discard();
//            tempCard = temp.pop();
            tempCard = userPlay.cardToDrop().pop();  // get the card the user wants to drop
            pickUpPile.getPickUp().push(tempCard);  // then add it to the discard pile
//            userPlay.showPlayHand();
            discardPile.showDiscardPile();
                break;}
        } // end switch case
        } // end my turn

        while (!myTurn){

        } // end computer turn







//        for (Card card : userPlay.playHand.getCards()){
//
//            System.out.println(temp);
//            userPlay.playHand.removeCard(temp);
//            userPlay.showPlayHand();
//        }



        // make deck the pick up pile

        // make top card from pick up pile the discard pile

        // until there is a winner
            // take turn Player
                // show hand
                // pick card to play
                // if card to play
                    // pop from hand, push to discard
                // else if no card to play
                    // pick from discard
                        // if still no card to play
                            // pass
                        // else
                            // pop card and push to discard

            // take turn Computer
                // see hand (don't display)
                // strategize card to pick
                    // do I have the same suit?
                        // play card
                    // do I have the same rank?
                        // play card
                    // do I have an 8?
                        // what's my strongest suit?
                            // set suit
                            // play card

            // output game results
            // TODO play again?




//    Card dealt = deck.dealCard();
//    System.out.println(dealt);

    } // end main fn
} // end main class