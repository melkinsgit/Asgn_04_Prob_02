package com.margaret;
import java.util.*;

public class ElkinsEights {

    public static void main(String[] args) {

        LinkedList<Card> temp = new LinkedList<>();
        Card tempCard = new Card();
        boolean myTurn = false;
        int pickPlay = 0;
        String winner = "";


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
//        PickUp pickUpPile = new PickUp(deck.getDeck());
        PickUp pickUpPile = new PickUp(); // jfor testing running out of cards in pick up pile
        pickUpPile.getPickUp().push(deck.getDeck().pop());
        pickUpPile.getPickUp().push(deck.getDeck().pop());
        pickUpPile.getPickUp().push(deck.getDeck().pop());
        pickUpPile.getPickUp().push(deck.getDeck().pop());
//        PickUp pickUpPile = new PickUp(discardPile.getTopCard());
        Discard discardPile = new Discard(pickUpPile.getTopCard());
        pickUpPile.showPickUpPile();
        System.out.println("That's the pick up pile before we start playing.");

        // TODO while there is no winner

        myTurn = true;

        while (winner.equals("")) {
            discardPile.showDiscardPile();
            while (myTurn && !userPlay.win) {

                userPlay.showPlayHand();
                pickPlay = userPlay.chooseMove();

                switch (pickPlay) {

                    case 1: {
                        //            temp = userPlay.Discard();
                        //            tempCard = temp.pop();
                        tempCard = userPlay.cardToDrop().pop();  // get the card the user wants to drop
                        discardPile.getDiscard().push(tempCard);  // then add it to the discard pile
                        //            userPlay.showPlayHand();
                        discardPile.showDiscardPile();
                        myTurn = false;
                        break;
                    }

                    case 2: {
                        if (!pickUpPile.moreCards()){
                            refreshDiscard (discardPile, pickUpPile);
                        }
                        else {
//                            System.out.println("The pick up is empty. The discard pile will be recycled as the pick up pile.");
//                            tempCard = discardPile.getTopCard().pop();
//                            System.out.println("The new discard pile is :" + tempCard);
//                            pickUpPile.setPickUp(discardPile.getDiscard());
//                            Collections.shuffle(pickUpPile.getPickUp());
//                            System.out.println("The new pick up pile has " + pickUpPile.getPickUp().size() + " cards.");
//                            discardPile.getDiscard().push(tempCard);
//                            discardPile.seeTopCard();
                            tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the pick up pile
                            userPlay.addCard(tempCard);
                            System.out.println(tempCard + " was added to your hand.");
                            userPlay.showPlayHand();
                            myTurn = false;
                        }
                        break;
                    }

                    case 3: {
                        System.out.println("I pass this turn. Can't play.");
                        myTurn = false;
                        break;
                    }

                } // end switch case
                if (!userPlay.moreCards()){
                    userPlay.setWin(true);
                }
            } // end my turn

            if (userPlay.win) {
                System.out.println(userPlay.getPlayName() + " won the game.");
                myTurn = true;
                winner = userPlay.getPlayName();
            }

            while (!myTurn && !compPlay.win) {

                compPlay.showPlayHand();
                pickPlay = compPlay.chooseMove(discardPile, pickUpPile);

                if (pickPlay == 0){
                    if (!pickUpPile.moreCards()){
                        refreshDiscard (discardPile, pickUpPile);
                    }
                    else {
                        tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the discard pile
                        compPlay.addCard(tempCard);
                        System.out.println("The " + tempCard + " was added to Computer's hand.");
                        compPlay.showPlayHand();
                    }
                }
                myTurn = true;

            } // end computer turn

            if (!userPlay.win && compPlay.win){
                System.out.println(compPlay.getPlayName()+ " won the game.");
                winner = compPlay.getPlayName();
            }
        }






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

    public static void refreshDiscard(Discard discard, PickUp pickup){
        Card tempCard = new Card();
        System.out.println("The pick up is empty. The discard pile will be recycled as the pick up pile.");
        tempCard = discard.getTopCard().pop();
        pickup.setPickUp(discard.getDiscard());
        Collections.shuffle(pickup.getPickUp());
        System.out.println("The new pick up pile has " + pickup.getPickUp().size() + " cards.");
        discard.getDiscard().push(tempCard);
        discard.showDiscardPile();
    }
} // end main class