import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck, ArrayList<Player> players){
        this.deck = deck;
        this.players = players;
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
        for (Player player : this.players) {
            Card card = dealCardsToPlayers(deck);
            player.addCardToHand(card);
        }
    }

    public Player checkWinner() {
        if (checkDraw()) {
            return null;
        }
        Player winner = players.get(0);
        for (Player player : this.players) {
            if (player.getHandValue() > winner.getHandValue()) {
                winner = player;
            }
        }
        return winner;
    }

    public boolean checkDraw() {
        boolean draw = false;
        for (Player player : players) {
            if (player.getHandValue() == players.get(0).getHandValue()) {
                draw = true;
            } else {
                draw = false;
            }
        }
        return draw;
    }

}
