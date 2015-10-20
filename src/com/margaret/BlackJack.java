package com.margaret;
import java.util.*;

public class BlackJack {

    public static void main(String[] args) {

        // TODO while you still want to play
        // create a deck
        Deck deck = new Deck();

        // shuffle deck
        deck.shuffle();

//        Hand compHand = new Hand ();
//        Player user = new Player();


//        Hand compHand = new Hand();
//        Hand userHand = new Hand();

        Player compPlay = new Player("Computer");
        Player userPlay = new Player("User");
//
        compPlay.showPlayHand();
        userPlay.showPlayHand();

        compPlay.setPlayHand(new Hand(deck.dealHand()));
        compPlay.showPlayHand();

        userPlay.setPlayHand(new Hand(deck.dealHand()));
        userPlay.showPlayHand();

        Discard discardPile = new Discard(deck.getDeck());
        discardPile.showDiscardPile();

        PickUp pickUpPile = new PickUp(discardPile.getTopCard());
        pickUpPile.showPickUpPile();

//        Card test = new Card();
//        int i = 0;
//        while (i <= 52){
//            if (deck.moreCards()) {
//                test = deck.dealCard();
//                System.out.println(test);
//                i++;
//            }
//            else {
//                System.out.println("Out of cards!");
//                break;
//            }
//        }

        // deal player 7 cards - pop

        // deal computer 7 cards - pop

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