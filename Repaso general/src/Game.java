import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Deck deck;
    private int rounds;

    public Game(int numPlayers, int rounds) {
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.rounds = rounds;

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            players.add(new Player(scanner.nextLine()));
        }
    }

    public void start() {
        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);

            // Deal cards to players
            for (Player player : players) {
                player.receiveCard(deck.dealCard());
                player.receiveCard(deck.dealCard());
            }

            // Play round
            playRound();

            // Display scores
            displayScores();
        }

        // Display final winner
        displayWinner();
    }

    private void playRound() {
        Card highestCard = null;
        Player roundWinner = null;

        for (Player player : players) {
            Card card = player.playCard();
            System.out.println(player + " plays " + card);
            if (highestCard == null || card.getValue() > highestCard.getValue()) {
                highestCard = card;
                roundWinner = player;
            } else if (card.getValue() == highestCard.getValue()) {
                roundWinner = null; // Tie
            }
        }

        if (roundWinner != null) {
            System.out.println("Round winner: " + roundWinner.getName());
            roundWinner.incrementScore();
        } else {
            System.out.println("It's a tie! No points awarded.");
        }
    }

    private void displayScores() {
        System.out.println("\nScores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    private void displayWinner() {
        Player winner = null;
        for (Player player : players) {
            if (winner == null || player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        System.out.println("\nGame Over!");
        System.out.println("Winner: " + (winner != null ? winner.getName() : "No one"));
    }
}
