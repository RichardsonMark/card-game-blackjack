import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Card card;
    Card card2;
    Card card3;

    @Before
    public void before(){
        player = new Player();
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
        card2 = new Card(SuitType.SPADES, RankType.ACE);
        card3 = new Card(SuitType.CLUBS, RankType.ACE);

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

    @Test
    public void canMakeAceHigh(){
        player.addCardToHand(card);
        player.addCardToHand(card2);
        assertEquals(21, player.makeAceHigh());
    }

    @Test
    public void cannotGoBustWithTwoAces(){
        player.addCardToHand(card3);
        player.addCardToHand(card2);
        assertEquals(12, player.makeAceHigh());
    }

//    @Test
//    public void checkCardsInHand(){
//        player.addCardToHand(card);
////        player.addCardToHand(card2);
//        assertEquals(RankType.QUEEN, card.getRank());
//        assertEquals(SuitType.HEARTS, card.getSuit());
//        assertEquals(RankType.QUEEN, ());
//    }


}
