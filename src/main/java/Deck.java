import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public int getNumberOfCards() {
        return this.cards.size();
    }

    public void populateDeck() {
        for (SuitType suit : SuitType.values()) {
            for (RankType rank : RankType.values()) {
                Card card = new Card(suit, rank);
                this.cards.add(card);

            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public void dealCard(Player player) {
        this.cards.remove(0);
        this.player.addCardToHand();
    }
}
