import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(){
        this.deck = new Deck();
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public int getNumPlayers(){
        return this.players.size();
    }

    public void dealCardsToPlayers(){
        for (Player player : players) {
            deck.dealCard(player);
        }
    }

}
