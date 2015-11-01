package com.margaret;

public class Computer extends Player {

    // constructor - just sets the playName per the super class Player
    public Computer(String name) {
        super(name);
    }

    public int chooseMove (Discard discard){
        int i = 0;

        // first check the entire hand to see if there is a matching suit, this is the most likely option with 12 potential matches
        for (Card card : playHand.getCards()) {
            if (card.getSuit().equals(discard.seeTopCard().getSuit())) {
                discard.getDiscard().push(card);  // add card it to the discard pile
                playHand.getCards().remove(i); // remove the card from the hand
                System.out.println(this.playName + " discarded the " + card);  // confirm the discard for the user
                return 5;
            }
            i++;
        }
        // reset the counter to run through the cards again
        i = 0;

        // second check the entire hand for a matching rank, this is the second most likely option with 3 potential matches
        for (Card card : playHand.getCards()) {
            if (card.getRank().equals(discard.seeTopCard().getRank())){
                discard.getDiscard().push(card);  // add card it to the discard pile
                playHand.getCards().remove(i); // remove the card from the hand
                System.out.println(this.playName + " discarded the " + card);  // confirm the discard for the user
                return 5;
            }
            i++;
        }
        // reset counter again for final pass
        i = 0;

        // finally check the hand for an 8, an option as likely as a matching rank with 3 potential matches
        for (Card card : playHand.getCards()) {
            if (card.getRank().equals("8")){
                discard.getDiscard().push(card);  // add card it to the discard pile
                playHand.getCards().remove(i);  // remove the card from the hand
                System.out.println(this.playName + " discarded the " + card);  // confirm the discard for the user
                return 5;
            }
            i++;
        }
        return 0;
    }

    public boolean compTurn (Discard discardPile, PickUp pickUpPile) {
        int pickPlay;
        boolean gameOver = false;
        Card tempCard;

        pickPlay = this.chooseMove(discardPile);

        // if the computer didn't discard during choose move
        if (pickPlay == 0) {
            System.out.println("The computer has chosen to pick up a card.");
            if (!pickUpPile.moreCards()) {  // if there are no more cards in the pick up pile refresh the pick up pile
                if (discardPile.getDiscard().size() < 2) {  // unless there aren't enough cards in the discard pile
                    gameOver = true;  // if there aren't enough cards to play, even if there is not winner, the game is over
                    return gameOver;
                } else { //
                    ElkinsEights.refreshDiscard(discardPile, pickUpPile);
                }
            }
            tempCard = pickUpPile.getPickUp().pop();  // pick up a card from the discard pile
            this.addCard(tempCard);  // add the card to the computer's hand
            System.out.println("A card was added to Computer's hand.");  // don't tell the user which card the computer got
        }

        // if we're still in play and the computer has no more cards, the computer has won
        if (!gameOver && !this.moreCards()) {  // and if the user played their last card they won
            this.setWin(true);  // set the user's boolean to true showing they won
            System.out.println(this.getPlayName() + " won the game.");  // print a message to the screen
            gameOver = true;  // and set the game over boolean to true showing the game is over
        }
        return gameOver; // if the computer has won game over will be true
    }

    public void addCard (Card c){
        playHand.getCards().push(c);
    }
}
