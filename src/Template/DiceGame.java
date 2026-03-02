package Template;

import java.util.Random;

public class DiceGame extends Game {

    private int[] scores;
    private int numberOfPlayers;
    private int winner = -1;
    private final int WINNING_SCORE = 30;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        scores = new int[numberOfPlayers];

        System.out.println("Starting Dice Game with " + numberOfPlayers + " players.");
        System.out.println("First player to reach " + WINNING_SCORE + " points wins!\n");
    }

    @Override
    public boolean endOfGame() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (scores[i] >= WINNING_SCORE) {
                winner = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = random.nextInt(6) + 1;
        scores[player] += roll;

        System.out.println("Player " + (player + 1) + " rolled: " + roll);
        System.out.println("Player " + (player + 1) + " total score: " + scores[player] + "\n");
    }

    @Override
    public void displayWinner() {
        System.out.println("🎉 Player " + (winner + 1) + " wins with " + scores[winner] + " points!");
    }
}