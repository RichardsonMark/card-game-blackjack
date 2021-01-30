import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;
    private Dealer dealer;

    public Game(Deck deck, ArrayList<Player> players, Dealer dealer){
        this.deck = deck;
        this.players = players;
        this.dealer = dealer;
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
        for (Player player : this.players) {
            if (player.makeAceHigh() > dealer.makeDealerAceHigh()) {
                String winner1 = "Player wins with a hand worth " + player.makeAceHigh();
                return winner1;
            }else{
                String winner2 = "Dealer wins with a hand worth " + dealer.makeDealerAceHigh();
                return winner2;
            }
        }
        return winner;
    }

    public String checkForBlackjack() {
        String notBlackjack = "No Blackjack this time.";
        for (Player player : this.players) {
            if (player.makeAceHigh() == 21 || dealer.makeDealerAceHigh() == 21) {
                String blackjack1 = "Blackjack!!";
                return blackjack1;
            } else {
                String noBlackJack = "";
                return noBlackJack;
            }
        }
        return notBlackjack;
    }



    // commenting out methods of old game

//    public Player checkWinner() {
//        if (checkDraw()) {
//            return null;
//        }
//        Player winner = players.get(0);
//        for (Player player : this.players) {
//            if (player.getHandValue() > winner.getHandValue()) {
//                winner = player;
//            }
//        }
//        return winner;
//    }
//
//    public boolean checkDraw() {
//        boolean draw = false;
//        for (Player player : players) {
//            if (player.getHandValue() == players.get(0).getHandValue()) {
//                draw = true;
//            } else {
//                draw = false;
//            }
//        }
//        return draw;
//    }

}
