package com.margaret;

public class Player {
    protected Hand playHand;
    protected String playName;
    protected boolean win;

    public Player (){
        this.playHand = new Hand();
        this.playName = "";
    }

    public Player (String name){
        this.playName = name;
        this.playHand = new Hand();
        this.win = false;
    }

    public Hand getPlayHand() {
        return playHand;
    }

    public String getPlayName() {
        return playName;
    }

    public boolean getWin() { return win; }

    public void setPlayHand(Hand playHand) {
        this.playHand = playHand;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public void setWin(boolean winVal) { this.win = winVal; }

    public void showPlayHand(){
        int cardCount = 1;
        if (moreCards()) {
            System.out.println(playName + "'s hand is:");
            for (Card card : playHand.getCards()) {
                System.out.println("\t" + cardCount + ": " + card);
                cardCount++;
            }
        }
    }

    public boolean moreCards() {
        if (playHand.getCards().size() > 0) {
            return true;
        } else {
            System.out.println(playName + " has no more cards.");
            return false;
        }
    }
}
