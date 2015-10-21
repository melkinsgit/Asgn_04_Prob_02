package com.margaret;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by sn0173nd on 10/19/2015.
 */
public class User extends Player {

    public User(String name) {
        super(name);
    }

    public void Discard (){
        int choice = 0;
        int cardCount = 1;
        LinkedList<Card> dropCard = new LinkedList<>();
        boolean valid = false;
        String choiceStr = "";
        Scanner scan = new Scanner(System.in);
        for (Card card : this.playHand.getCards()){
            System.out.println(cardCount + ": " + card);
            cardCount++;
        }
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

        playHand.getCards().remove(choice-1);
    }
}
