import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> dealerHand;

    public Dealer() {
        this.dealerHand = new ArrayList<>();
    }


    public Card deal(Deck deck) {
        return deck.dealCard();
    }
}
