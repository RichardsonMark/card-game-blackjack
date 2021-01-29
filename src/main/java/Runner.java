import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
        deck.populateDeck();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        Game game = new Game(deck, players, dealer);
        System.out.println("Let's play some Blackjack");
        game.play();
        System.out.println("Dealer is dealing...");
        System.out.println("Game in progress...");
        System.out.println(game.highestHandWinner());
    }

}
