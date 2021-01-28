import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;

    @Before
    public void before() {
        deck = new Deck();
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

}
