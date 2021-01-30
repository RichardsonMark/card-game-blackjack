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
        System.out.println("Dealer card drawn. " + card.getRank() + " of " + card.getSuit() + " added to hand.");

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

    public int makeDealerAceHigh(){
        int totalHandValue = this.getDealerHandValue();
        if(totalHandValue <= 11){
            int total = 0;
            for(Card card : this.dealerHand){
                if (card.getRank() == RankType.ACE){
                    total +=1;
                }
            }
            return total * 10 + totalHandValue;
        }
        return this.getDealerHandValue();
    }
}
