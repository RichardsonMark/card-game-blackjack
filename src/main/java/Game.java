import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;
    private Dealer dealer;
    private boolean playerIsBust;
    private boolean dealerIsBust;

    public Game(Deck deck, ArrayList<Player> players, Dealer dealer){
        this.deck = deck;
        this.players = players;
        this.dealer = dealer;
        this.playerIsBust = false;
        this.dealerIsBust = false;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public int getNumPlayers(){
        return this.players.size();
    }

    public Card dealCardsToPlayers(Deck deck){
//        for (Player player : players) {
            return deck.dealCard();
//        }
    }

    public void play() {
        deck.shuffleDeck();
        Card dealerCard1 = dealer.deal(deck);
        dealer.addCardsToDealersHand(dealerCard1);
        Card dealerCard2 = dealer.deal(deck);
        dealer.addCardsToDealersHand(dealerCard2);
        for (Player player : this.players) {
            Card card = dealCardsToPlayers(deck);
            player.addCardToHand(card);
            Card card2 = dealCardsToPlayers(deck);
            player.addCardToHand(card2);
        }
    }

    public String highestHandWinner(){
        String winner ="";
        playerDecidesIfShouldTwist();
        dealerDecidesIfShouldTwist();
        playerDecidesIfShouldStick();
        dealerDecidesIfShouldStick();
//        checkIfPlayerBust();
//        checkIfDealerBust();
        for (Player player : this.players) {
            if (player.playerHandValueAbleToMakeAceHigh() > dealer.dealerHandValueAbleToMakeAceHigh()) {
                String winner1 = "Player wins with a hand worth " + player.playerHandValueAbleToMakeAceHigh();
                return winner1;
            }else if(player.playerHandValueAbleToMakeAceHigh() == dealer.dealerHandValueAbleToMakeAceHigh()){
                String draw = "It's a draw!";
                return draw;
            }
            else if (this.checkIfDealerBust() == true) {
                String dealerBust = "Dealer is bust, player wins!!";
                return dealerBust;
            }else if (this.checkIfPlayerBust() == true){
                    String playerBust = "Player is bust :(";
                    return playerBust;
                }else{
                String winner2 = "Dealer wins with a hand worth " + dealer.dealerHandValueAbleToMakeAceHigh();
                return winner2;
            }
        }
        return winner;
    }

    public String checkForBlackjack() {
        String notBlackjack = "No Blackjack this time.";
        for (Player player : this.players) {
            if (player.playerHandValueAbleToMakeAceHigh() == 21 || dealer.dealerHandValueAbleToMakeAceHigh() == 21) {
                String blackjack1 = "Blackjack!!";
                return blackjack1;
            } else {
                String noBlackJack = "";
                return noBlackJack;
            }
        }
        return notBlackjack;
    }

    public void playerDecidesIfShouldTwist(){
        for (Player player : players){
            if(player.playerHandValueAbleToMakeAceHigh() < 16) {
                Card card3 = dealer.deal(deck);
                System.out.println("Player twists...");
                player.addCardToHand(card3);
            }
        }
    }

    public boolean playerDecidesIfShouldStick(){
        for (Player player : this.players) {
            if (player.playerHandValueAbleToMakeAceHigh() >= 16) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public void dealerDecidesIfShouldTwist(){
        if (dealer.dealerHandValueAbleToMakeAceHigh() < 16){
            Card card = dealer.deal(deck);
            System.out.println("Dealer twists...");
            dealer.addCardsToDealersHand(card);
        }
    }

    public boolean dealerDecidesIfShouldStick(){
        if (dealer.dealerHandValueAbleToMakeAceHigh() >= 16) {
            return true;
        }else{
            return false;
        }
    }

    public boolean checkIfPlayerBust(){
        for (Player player : this.players) {
            if (player.playerHandValueAbleToMakeAceHigh() <= 21) {
                this.playerIsBust = false;
            }else{
                this.playerIsBust = true;
            }
        }
        return this.playerIsBust;
    }

    public boolean checkIfDealerBust(){
        if (dealer.dealerHandValueAbleToMakeAceHigh() <= 21){
            this.dealerIsBust = false;
        }else{
            this.dealerIsBust = true;
        }
        return this.dealerIsBust;
    }

}
