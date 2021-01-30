import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {

    Game game;
    Deck deck;
    Player player1;
//    Player player2;
    Dealer dealer;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player();
//        player2 = new Player();
        dealer = new Dealer();
        deck.populateDeck();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
//        players.add(player2);
        game = new Game(deck, players, dealer);
    }

    @Test
    public void canAddPlayer(){
        assertEquals(1, game.getNumPlayers());
    }

    @Test
    public void canDealCardsToPlayers(){
        game.addPlayer(player1);
        Card card = game.dealCardsToPlayers(deck);
        assertNotNull(card);
        assertEquals(51, deck.getNumberOfCards());
    }

    @Test
    public void canPlay(){
        game.play();
        assertEquals(2, player1.numberOfCardsInHand());
//        assertEquals(2, player2.numberOfCardsInHand());
        assertEquals(2, dealer.numberOfCardsInDealersHand());
        assertEquals(48, deck.getNumberOfCards());
    }

    @Test
    public void checkWhoWinsHighestHandTestGame(){
        deck.populateDeck();
        deck.shuffleDeck();
        player1.addCardToHand(new Card(SuitType.DIAMONDS, RankType.KING));
        dealer.addCardsToDealersHand(new Card(SuitType.HEARTS, RankType.NINE));
        player1.addCardToHand(new Card(SuitType.CLUBS, RankType.KING));
        dealer.addCardsToDealersHand(new Card(SuitType.SPADES, RankType.NINE));
        assertEquals("Player wins with a hand worth " + player1.makeAceHigh(), game.highestHandWinner());
    }

    @Test
    public void checkWhoWinsHighestHandRealGame(){
        deck.populateDeck();
        deck.shuffleDeck();
        game.play();
        assertTrue(game.highestHandWinner().equals("Dealer wins with a hand worth " + dealer.getDealerHandValue()) || game.highestHandWinner().equals("Player wins with a hand worth " + player1.makeAceHigh()));
    }

    @Test
    public void checkForBlackjackIsBlackjack(){
        player1.addCardToHand(new Card(SuitType.DIAMONDS, RankType.KING));
        player1.addCardToHand(new Card(SuitType.CLUBS, RankType.ACE));
        // asserting with getHandValue to make sure 11 as expected
        assertEquals(11, player1.getHandValue());
        // asserting with makeAceHigh to make sure Ace goes high as expected
        assertEquals(21, player1.makeAceHigh());
        // asserting with makeAceHigh added to BlackJack test
        assertEquals("Blackjack!!", game.checkForBlackjack());
    }

    @Test
    public void checkForBlackjackIsNotBlackjack(){
        player1.addCardToHand(new Card(SuitType.DIAMONDS, RankType.KING));
        player1.addCardToHand(new Card(SuitType.CLUBS, RankType.QUEEN));
        // asserting with getHandValue to make sure 11 as expected
        assertEquals(20, player1.getHandValue());
        // asserting with makeAceHigh to make sure doesn't goes high (no Ace in hand)
        assertEquals(20, player1.makeAceHigh());
        // asserting with makeAceHigh added to BlackJack test (no Ace in hand)
        assertEquals("", game.checkForBlackjack());
    }


    // commenting out logic of old game
//    @Test
//    public void player1Wins(){
//        player1.addCardToHand(new Card(SuitType.DIAMONDS, RankType.KING));
//        player2.addCardToHand(new Card(SuitType.HEARTS, RankType.NINE));
//        assertEquals(player1, game.checkWinner());
//    }
//
//    @Test
//    public void drawReturnsNull(){
//        player1.addCardToHand(new Card(SuitType.CLUBS, RankType.FIVE));
//        player2.addCardToHand(new Card(SuitType.SPADES, RankType.FIVE));
//        assertNull(game.checkWinner());
//    }

}
