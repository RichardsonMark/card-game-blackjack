import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        Deck deck = new Deck();
        Player player = new Player();
        Player player2 = new Player();
        Dealer dealer = new Dealer();
        deck.populateDeck();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player2);
        Game game = new Game(deck, players, dealer);
        System.out.println("Let's play some Blackjack");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Dealer is dealing...");
        game.play();
        System.out.println("Players deciding whether to stick or twist...");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(game.highestHandWinner());
        System.out.println(game.checkForBlackjack());
    }

}
