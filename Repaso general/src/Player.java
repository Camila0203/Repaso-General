import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        if (hand.isEmpty()) return null;
        return hand.remove(0);
    }

    public List<Card> getHand() {
        return hand;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + hand.toString();
    }
}
