import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        Card card = game.dealCardsToPlayers(deck);
//        assertEquals(1, player1.getHand().size());
//        assertEquals(1, player2.getHand().size());
        assertNotNull(card);
        assertEquals(51, deck.getNumberOfCards());
    }

}
