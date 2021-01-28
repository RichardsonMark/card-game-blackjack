import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Deck deck;
    Player player1;
    Player player2;

    @Before
    public void before(){
        game = new Game();
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
        deck.populateDeck();
    }


    @Test
    public void canAddPlayer(){
        game.addPlayer(player1);
        assertEquals(1, game.getNumPlayers());
    }

    @Test
    public void canDealCardsToPlayers(){
        game.addPlayer(player1);
        game.dealCardsToPlayers();
        assertEquals(1, player1.getHand().size());
//        assertEquals(1, player2.getHand().size());
        assertEquals(51, deck.getNumberOfCards());
    }

}
