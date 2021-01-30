import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void canGetACard() {
        deck.populateDeck();
        deck.shuffleDeck();
        assertNotNull(deck.dealCard());
        assertEquals(51, deck.getNumberOfCards());
    }



}
