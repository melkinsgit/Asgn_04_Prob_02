package com.margaret;
import java.awt.*;
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
            LinkedList<Card> tempDeck = deck.getDeck();
            deck.shuffle();

            // instantiate a Computer and User, which are subclasses of Player
            Computer compPlay = new Computer("Computer");
            User userPlay = new User(userName);  // give the user the name the user entered at the beginning

            // deal computer and player 7 cards each
            compPlay.setPlayHand(new Hand(deck.dealHand()));
//            compPlay.showPlayHand();
            userPlay.setPlayHand(new Hand(deck.dealHand()));
//            userPlay.showPlayHand();

            // create a pick up pile made of what remains of the deck
            PickUp pickUpPile = new PickUp(Deck.deck);
            deck = new Deck(0);  // get rid of the old deck so when you play again, you are the deck doesn't include cards from the previous game

            // create a discard pile of the top card on the pick up pile
            // there is now one less card in the pick up pile, and one card in the discard pile
            Discard discardPile = new Discard(pickUpPile.getTopCard());

            // until someone wins or we run out of cards in the pick up pile
            while (!gameOver) {

                gameOver = userPlay.userTurn(discardPile, pickUpPile);
                if (gameOver){break;}
                gameOver = compPlay.compTurn(discardPile, pickUpPile);
            }

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