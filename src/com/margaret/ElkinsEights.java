package com.margaret;
import java.util.*;

public class ElkinsEights {

    protected Card inPlay = new Card();

    public static void main(String[] args) {

        LinkedList<Card> temp = new LinkedList<>();
        Card tempCard = new Card();
        boolean myTurn = false;
        int pickPlay = 0;
        String winner = "";
        boolean gameOver = false;
        boolean playMore = true;
        String reply;
        Scanner c = new Scanner(System.in);


        // TODO while you still want to play
        while (playMore) {

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

            pickUpPile.showPickUpPile();
//        PickUp pickUpPile = new PickUp(discardPile.getTopCard());
            Discard discardPile = new Discard(pickUpPile.getTopCard());
            System.out.println("After moving one card to the discard pile the discard pile is: ");
            discardPile.showDiscardPile();
            System.out.println("And the pick up pile is: ");
            pickUpPile.showPickUpPile();
            System.out.println("That's the pick up pile before we start playing.");

            while (!gameOver) {

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
//                            tempCard = userPlay.cardToDrop().pop();  // get the card the user wants to drop

                                boolean discarded = false;
                                tempCard = userPlay.cardToDrop();
                                while (!discarded) {
                                    if (isValid(tempCard, discardPile)) {
//                                    discardPile.getDiscard().push(tempCard);  // then add it to the discard pile
                                        discardPile.addCard(tempCard);
                                        System.out.println("Card discarded is " + tempCard);
                                        discarded = true;
                                    } else {
                                        System.out.println("Sorry, you can't discard that card. Try again.");
//                                    userPlay.playHand.getCards().push(tempCard);
                                        userPlay.addCard(tempCard);
                                    }
                                }

//                            System.out.println("Card discarded is " + tempCard);

                                //            userPlay.showPlayHand();
                                discardPile.showDiscardPile();
                                myTurn = false;
                                break;
                            }

                            case 2: {
                                if (!pickUpPile.moreCards()) {
                                    System.out.println("Out of cards. Game over!");
                                    myTurn = false;
                                    gameOver = true;
                                    break;
                                }
//                            refreshDiscard (discardPile, pickUpPile);
//                            System.out.println("Just returned from refresh discard now the top of the discard is " + discardPile.seeTopCard());
//                            System.out.println("Also, there are " + pickUpPile.getPickUp().size() + " cards in the pick up pile now.");

                                tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the pick up pile
                                System.out.println("the new card from the pick up pile is " + tempCard);
                                userPlay.addCard(tempCard);
                                System.out.println(tempCard + " was added to your hand.");
                                userPlay.showPlayHand();
                                myTurn = false;
                                break;
                            }

                            case 3: {
                                System.out.println("I pass this turn. Can't play.");
                                myTurn = false;
                                break;
                            }

                        } // end switch case

                        if (gameOver) break;

                        if (!userPlay.moreCards()) {
                            userPlay.setWin(true);
                            gameOver = true;
                        }
                    } // end my turn

                    if (userPlay.win) {
                        System.out.println(userPlay.getPlayName() + " won the game.");
                        myTurn = true;
                        winner = userPlay.getPlayName();
                        userPlay.setWin(true);
                        gameOver = true;
                        break;
                    }

                    if (gameOver) break;

                    while (!myTurn && !compPlay.win) {

                        compPlay.showPlayHand();
                        pickPlay = compPlay.chooseMove(discardPile);

                        if (pickPlay == 0) {
                            if (!pickUpPile.moreCards()) {
                                System.out.println("Out of cards. Game over!");
                                myTurn = true;
                                gameOver = true;
                                break;
//                        refreshDiscard (discardPile, pickUpPile);
                            } else {
                                tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the   pile
                                compPlay.addCard(tempCard);
                                System.out.println("The " + tempCard + " was added to Computer's hand.");
                                compPlay.showPlayHand();
                            }
                        }
                        myTurn = true;

                    } // end computer turn

                    if (gameOver) break;

                    if (!userPlay.win && compPlay.win) {
                        System.out.println(compPlay.getPlayName() + " won the game.");
                        winner = compPlay.getPlayName();
                        gameOver = true;
                    }
//                if (!userPlay.win && !compPlay.win) {
//                    System.out.println("It's a tie. No winner this time.");
//                    gameOver = true;
//                }
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

            System.out.println("Want to play another game? (y or n)");
            reply = c.nextLine();
            if (reply.equals("n") || reply.equals("N")){
                playMore = false;
            }


        }


//    Card dealt = deck.dealCard();
//    System.out.println(dealt);

    } // end main fn

    public static void refreshDiscard(Discard discard, PickUp pickup){
        Card tempCard1 = new Card();
        System.out.println("The pick up is empty. The discard pile will be recycled as the pick up pile.");
        System.out.println("There are " + discard.getDiscard().size() + " cards in the discard pile. And the top card is: ");
        tempCard1 = discard.getTopCard().pop();  // remove the top card from the discard pile
        System.out.println(tempCard1);
        pickup.setPickUp(discard.getDiscard());  // make the pick up pile what's left of the discard pile
        System.out.println("There are " + pickup.getPickUp().size() + " cards in the pick up pile.");
        Collections.shuffle(pickup.getPickUp());  // shuffle the pick up pile
        System.out.println("The new pick up pile has been shuffled.");
        discard.showDiscardPile();  // this shows the tempCard1 value still in the pile, even though it was popped
        discard.getDiscard().push(tempCard1);  // then I push tempCard1 to the discard pile ...
        discard.showDiscardPile();  // ... and now the discard pile shows ONLY the tempCard1
    }

    public static boolean isValid (Card card, Discard discard) {
        if (card.getRank().equals(discard.seeTopCard().getRank())) {
            return true;  // add card it to the discard pile
        } else if (card.getSuit().equals(discard.seeTopCard().getSuit())) {
            return true;  // add card to the discard pile
        } else if (card.getRank().equals("8")) {
            return true;  // add card to the discard pile
        }
        return false;
    }
} // end main class