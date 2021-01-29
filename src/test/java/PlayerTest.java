import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Card card;

    @Before
    public void before(){
        player = new Player();
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
    }

    @Test
    public void checkHandStartsEmpty(){
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void canAddCardToHand(){
        player.addCardToHand(card);
        assertEquals(1, player.numberOfCardsInHand());
        Card card = (Card) player.getHand().get(0);
        assertEquals(SuitType.HEARTS, card.getSuit());
        assertEquals(RankType.QUEEN, card.getRank());
    }

    @Test
    public void canCheckHandValue(){
        player.addCardToHand(card);
        assertEquals(10, player.getHandValue());
    }


}
