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
        card = new Card(SuitType.SPADES, RankType.TWO);
        card2 = new Card(SuitType.SPADES, RankType.ACE);
    }

    @Test
    public void canDealCard() {
        deck.populateDeck();
        deck.shuffleDeck();
        Card card = dealer.deal(deck);
        assertNotNull(card);
        assertEquals(51, deck.getNumberOfCards());
    }

    @Test
    public void checkNoCardsInDealersHand(){
        assertEquals(0, dealer.numberOfCardsInDealersHand());
    }

    @Test
    public void canAddCardsToDealersHand(){
        dealer.addCardsToDealersHand(card);
        dealer.addCardsToDealersHand(card2);
        assertEquals(2, dealer.numberOfCardsInDealersHand());
    }

    @Test
    public void canRemoveAllCardsFromDealersHand(){
        dealer.addCardsToDealersHand(card);
        dealer.addCardsToDealersHand(card);
        assertEquals(2, dealer.numberOfCardsInDealersHand());
        dealer.removeAllCardsFromDealersHand();
        assertEquals(0, dealer.numberOfCardsInDealersHand());
    }

    @Test
    public void canCheckValueOfDealersHand(){
        dealer.addCardsToDealersHand(card);
        assertEquals(1, dealer.numberOfCardsInDealersHand());
        assertEquals(2, dealer.checkDealerScore());
    }
}
