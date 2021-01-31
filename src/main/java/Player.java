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
        System.out.println(Player.this + " card drawn. " + card.getRank() + " of " + card.getSuit() + " added to hand.");

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

    /**
     *
     * @return evolution of getHandValue, making ace high. returns int with total
     */
    public int playerHandValueAbleToMakeAceHigh(){
        int totalHandValue = this.getHandValue();
        if(totalHandValue > 2 && totalHandValue <= 11){
         int total = 0;
         for(Card card : this.hand){
             if (card.getRank() == RankType.ACE){
                 total +=1;
             }
         }
         return total * 10 + totalHandValue;
        }
        else if(totalHandValue == 2){
            return 10 + totalHandValue;
        }
        return this.getHandValue();
    }


}
