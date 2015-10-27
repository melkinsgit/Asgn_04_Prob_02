package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class User extends Player {

    public User(String name) {
        super(name);
    }



    public Card cardToDrop (){
        int choice = 0;
        Card dropCard = new Card();
        boolean valid = false;
        String choiceStr = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Which card would you like to discard?");
        choiceStr = scan.nextLine();

        while (!valid) {
            try {
                choice = Integer.parseInt(choiceStr);
                if (choice >= 1 && choice <= this.playHand.getSize()) {
                    valid = true;
                } else {
                    System.out.println("Sorry, that's not a valid choice. Please try again.");
                    choiceStr = scan.nextLine();
                }
            } catch (Exception ex) {
                System.out.println("Sorry, that's not a valid choice. Please try again.");
                choiceStr = scan.nextLine();
            }
//            System.out.println("Card discarded is " + this.playHand.getCards().get(choice - 1));
            dropCard = playHand.getCards().remove(choice-1);
        }
        return dropCard;
    }

    public int chooseMove (){

        int choice = 0;
//        LinkedList<Card> dropCard = new LinkedList<>();
        boolean valid = false;
        String choiceStr = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to do?\n\t1. Play a card to the discard pile.\n\t2. Pick up a card.\n\t3. Pass.");
        choiceStr = scan.nextLine();

        while (!valid) {
            try {
                choice = Integer.parseInt(choiceStr);
                if (choice >= 1 && choice <= 3) {
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

//        System.out.println("Card dropped is " + this.playHand.getCards().get(choice - 1));
//        dropCard.add(this.playHand.getCards().get(choice - 1));
//        playHand.getCards().remove(choice-1);

        return choice;
    }

    public void addCard (Card c){
        playHand.getCards().push(c);
    }
}
