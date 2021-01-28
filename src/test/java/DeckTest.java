import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Player player;

    @Before
    public void before() {
        deck = new Deck();
        player = new Player();
    }


    @Test
    public void checkDeckStartsEmpty() {
        assertEquals(0, deck.getNumberOfCards());
    }

    @Test
    public void checkDeckIsComplete() {
        deck.populateDeck();
        assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void canDealCard() {
        deck.populateDeck();
        deck.shuffleDeck();
        deck.dealCard(player);
        assertEquals(51, deck.getNumberOfCards());
        assertEquals(1, player.getHand().size());
    }

}
