package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class User extends Player {

    public User(String name) {
        super(name);
    }

    public LinkedList<Card> cardToDrop (){
        int choice = 0;
        LinkedList<Card> dropCard = new LinkedList<>();
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
        }

        System.out.println("Card dropped is " + this.playHand.getCards().get(choice - 1));
        dropCard.add(this.playHand.getCards().get(choice - 1));
        playHand.getCards().remove(choice-1);
        return dropCard;
    }

    public int chooseMove (){
        return 1;
    }
}
