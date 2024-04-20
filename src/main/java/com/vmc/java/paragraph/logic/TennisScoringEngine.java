package com.vmc.java.paragraph.logic;

public class TennisScoringEngine {

    private String player1Name;
    private String player2Name;
    private int player1Score = 0;
    private int player2Score = 0;

    private static final String[] SCORES = {"0", "15", "30", "40"};

    public TennisScoringEngine(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private void scorePointForPlayer(int player) {
        if (player == 1) {
            if (player1Score <= 3) {
                player1Score++;
            } else if (player2Score == 4) { // opponent had advantage
                player2Score--;
            } else {
                player1Score++;
            }
        } else {
            if (player2Score <= 3) {
                player2Score++;
            }  else if (player1Score == 4) { // opponent had advantage
                player1Score--;
            } else {
                player2Score++;
            }
        }
    }

    public String getCurrentScore() {
        if (player1Score >= 4) {
            return player1Name + " wins!";
        }
        if (player2Score >= 4) {
            return player2Name + " wins!";
        }
        if (player1Score == 3 && player2Score == 3) {
            return "Deuce";
        }
        if (player1Score == 4) {
            return "Advantage " + player1Name;
        }
        if (player2Score == 4) {
            return "Advantage " + player2Name;
        }
        return SCORES[player1Score] + " - " + SCORES[player2Score];
    }

    public static void main(String[] args) {
        TennisScoringEngine engine = new TennisScoringEngine("Player1", "Player2");

        // Test by updating scores
        engine.scorePointForPlayer(1);
        System.out.println(engine.getCurrentScore());
        
        engine.scorePointForPlayer(2);
        System.out.println(engine.getCurrentScore());
        
        engine.scorePointForPlayer(1);
        System.out.println(engine.getCurrentScore());
        
        engine.scorePointForPlayer(1);
        System.out.println(engine.getCurrentScore());
        
        engine.scorePointForPlayer(1);
        System.out.println(engine.getCurrentScore());

        // Continue the game...
    }
}

