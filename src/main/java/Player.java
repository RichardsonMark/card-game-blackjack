import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    public Player() {
        this.hand = new ArrayList<>();
    }

    public ArrayList getHand(){
        return this.hand;
    }

    public void addCardToHand(Card card){
        this.hand.add(card);

    }

    public int numberOfCardsInHand(){
        return this.hand.size();
    }

    public int getHandValue(){
        int total = 0;
        for (Card card : this.hand){
            total += card.getCardValue();
        }
        return total;

    }

}
