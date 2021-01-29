import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> dealerHand;

    public Dealer() {
        this.dealerHand = new ArrayList<>();
    }

    public Card deal(Deck deck) {
        return deck.dealCard();
    }

    public int numberOfCardsInDealersHand(){
        return this.dealerHand.size();
    }

    public void addCardsToDealersHand(Card card){
        this.dealerHand.add(card);
    }

    public void removeAllCardsFromDealersHand(){
        this.dealerHand.clear();
    }

    public int getDealerHandValue(){
        int total = 0;
        for (Card card : this.dealerHand){
            total += card.getCardValue();
        }
        return total;
    }
}
