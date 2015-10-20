package com.margaret;

import java.util.ArrayList;

/**
 * Created by sn0173nd on 10/19/2015.
 */
public class User extends Player {
    private ArrayList<Card> userHand;

    public User(ArrayList<Card> userHand) {
        this.userHand = userHand;
    }

    public ArrayList<Card> getUserHand() {
        return userHand;
    }

    public void setUserHand(ArrayList<Card> userHand) {
        this.userHand = userHand;
    }
}
