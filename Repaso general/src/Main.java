import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        System.out.print("Enter the number of rounds: ");
        int numRounds = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Game game = new Game(numPlayers, numRounds);
        game.start();
    }
}