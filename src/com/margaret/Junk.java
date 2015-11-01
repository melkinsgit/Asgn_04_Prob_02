package com.margaret;

/**
 * Created by Margaret on 10/20/2015.
 */
public class Junk {

//    Player compPlay = new Player("Computer");
//    Player userPlay = new Player("User");
////
//    compPlay.showPlayHand();
//    userPlay.showPlayHand();
//
//    compPlay.setPlayHand(new Hand(deck.dealHand()));
//    compPlay.showPlayHand();
//
//    userPlay.setPlayHand(new Hand(deck.dealHand()));
//    userPlay.showPlayHand();
//
//    Discard discardPile = new Discard(deck.getDeck());
//    discardPile.showDiscardPile();
//
//    PickUp pickUpPile = new PickUp(discardPile.getTopCard());
//    pickUpPile.showPickUpPile();

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

    // from case 2 when I thought I could refresh

//                            refreshDiscard (discardPile, pickUpPile);
//                            System.out.println("Just returned from refresh discard now the top of the discard is " + discardPile.seeTopCard());
//                            System.out.println("Also, there are " + pickUpPile.getPickUp().size() + " cards in the pick up pile now.");

    // start with the user's turn
//                myTurn = true;
//                // the user and the computer will play until one of them wins
//
//                while (winner.equals("")) {
//                    // then the user takes a turn until they win or their turn is over
//
////                    userPlay.playTurn();
//
//                    while (myTurn && !userPlay.win) {
//                        discardPile.showDiscardPile();
//                        // show the user their hand
//                        userPlay.showPlayHand();
//                        // then call a method that will have the user enter which game action they want, discard or pickup
//                        pickPlay = userPlay.chooseMove();
//
//                        switch (pickPlay) {
//                            // the user has chosen to discard from their hand
//                            case 1: {
//                                boolean discarded = false;
//                                // call a method to get the card the user wants to discard
//                                tempCard = userPlay.cardToDrop();
//
//                                // and until that card is a valid play, ask the user to keep choosing cards
//                                while (!discarded) {
//                                    if (isValid(tempCard, discardPile)) {  // if the user makes a valid choice
//                                        discardPile.addCard(tempCard);  // put that card on the top of the discard pile
//                                        System.out.println("Card discarded is " + tempCard);  // confirm the discard for the user
//                                        discarded = true;  // then set the flag to exit the loop
//                                    } else {  // otherwise, ask the user for another card to discard
//                                        System.out.println("Sorry, you can't discard that card. Try again.");
//                                        userPlay.addCard(tempCard);  // and put the card they originally discarded, back in their hand.
//                                        userPlay.showPlayHand();
//                                        discardPile.showDiscardPile();
//                                        tempCard = userPlay.cardToDrop();  // call the method to get the card the user wants to discard
//                                    }
//                                } // end of !discarded loop
//
//                                myTurn = false;  // now the user's turn is over
//                                break;  // so break out of the switch statement
//                            }
//
//                            case 2: {
//                                if (!pickUpPile.moreCards()) {
//                                    System.out.println("Out of cards. Game over!");
//                                    myTurn = false;
//                                    gameOver = true;
//                                    break;
//                                }
//
//                                tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the pick up pile
////                                System.out.println("the new card from the pick up pile is " + tempCard);
//                                userPlay.addCard(tempCard);
//                                System.out.println(tempCard + " was added to your hand.");
//                                userPlay.showPlayHand();
//                                myTurn = false;
//                                break;
//                            }
//
//                            default: {
//                                myTurn = false;
//                                break;
//                            }
//
//                        } // end switch case
//
//                        // game over can be set to true if there are no more cards in the pick up pile, so make sure the game hasn't ended
//                        if (gameOver) break;  // if the game is over break out of the while loop for the user's turn
//
//                        if (!userPlay.moreCards()) {  // and if the user played their last card they won
//                            userPlay.setWin(true);  // set the user's boolean to true showing they won
//                            System.out.println(userPlay.getPlayName() + " won the game.");  // print a message to the screen
//                            winner = userPlay.getPlayName();  // give the winner string a value
//                            gameOver = true;  // and set the game over boolean to true showing the game is over
//                        }
//                    } // end my turn
//
//                    if (userPlay.win) {  // if the user has won, don't give the computer another turn
//                        break;
//                    }
//
//                    while (!myTurn && !compPlay.win) {
//
//                        discardPile.showDiscardPile();
//
//                        compPlay.showPlayHand();
//                        pickPlay = compPlay.chooseMove(discardPile);
//
//                        if (pickPlay == 0) {
//                            if (!pickUpPile.moreCards()) {
//                                System.out.println("Out of cards. Game over!");
//                                myTurn = true;
//                                gameOver = true;
//                                break;
//                            } else {
//                                tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the discard pile
//                                compPlay.addCard(tempCard);
//                                System.out.println("The " + tempCard + " was added to Computer's hand.");
//                                compPlay.showPlayHand();
//                            }
//                        }
//
//                        if (!compPlay.moreCards()) {  // and if the Computer played their last card they won
//                            compPlay.setWin(true);  // set the Computer's boolean to true showing they won
//                            System.out.println(compPlay.getPlayName() + " won the game.");  // print a message to the screen
//                            winner = compPlay.getPlayName();  // give the winner string a value
//                            gameOver = true;  // and set the game over boolean to true showing the game is over
//                        }
//                        myTurn = true;
//
//                        if (gameOver) break;
//
//                        if (!userPlay.win && compPlay.win) {
//                            System.out.println(compPlay.getPlayName() + " won the game.");
//                            winner = compPlay.getPlayName();
//                            gameOver = true;
//                        }
//                    } // end computer turn
//                    if (gameOver) break;
//                } // end winner loop
//            } // end game over loop
}
