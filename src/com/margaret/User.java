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

        // TODO what if they try all their cards and they don't have any that will play?
        while (!valid) {
            try {
                choice = Integer.parseInt(choiceStr);
                if (choice >= 1 && choice <= this.playHand.getSize()) {
                    valid = true;
                }  else {
                    System.out.println("Sorry, that's not a valid choice from hand. Please try again.");
                    choiceStr = scan.nextLine();
                }
            } catch (Exception ex) {
                System.out.println("Sorry, that's not a valid choice another exception. Please try again.");
                choiceStr = scan.nextLine();
            }
        }
        dropCard = playHand.getCards().remove(choice-1);
        return dropCard;
    }

    public int chooseMove (){

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

    public void addCard (Card c){
        playHand.getCards().push(c);
    }
}
