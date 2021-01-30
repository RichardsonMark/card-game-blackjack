import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
        deck.populateDeck();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        Game game = new Game(deck, players, dealer);
        System.out.println("Let's play some Blackjack");
//        TimeUnit.SECONDS.sleep(1);
        System.out.println("Dealer is dealing...");
        game.play();
//        TimeUnit.SECONDS.sleep(1);
        System.out.println("Game in progress...");
//        TimeUnit.SECONDS.sleep(1);
        System.out.println(game.highestHandWinner());
        System.out.println(game.checkForBlackjack());
    }

}
