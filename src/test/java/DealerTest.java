import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DealerTest {

    Dealer dealer;
    Deck deck;
    Card card;
    Card card2;

    @Before
    public void before(){
        dealer = new Dealer();
        deck = new Deck();
        card = new Card(SuitType.HEARTS, RankType.FIVE);
        card2 = new Card(SuitType.CLUBS, RankType.ACE);
    }

    @Test
    public void canDealCard() {
        deck.populateDeck();
        deck.shuffleDeck();
        Card card = dealer.deal(deck);
        assertNotNull(card);
        assertEquals(51, deck.getNumberOfCards());
    }
}
