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
    Card card1;
    Card card2;
    Card card3;
    Card card4;


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
        card1 = new Card(SuitType.DIAMONDS, RankType.KING);
        card2 = new Card(SuitType.CLUBS, RankType.ACE);
        card3 = new Card(SuitType.CLUBS, RankType.QUEEN);
        card4 = new Card(SuitType.SPADES, RankType.NINE);
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
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);
        dealer.addCardsToDealersHand(card3);
        dealer.addCardsToDealersHand(card4);
        assertEquals("Player wins with a hand worth " + player1.playerHandValueAbleToMakeAceHigh(), game.highestHandWinner());
    }

    @Test
    public void checkWhoWinsHighestHandRealGame(){
        deck.populateDeck();
        deck.shuffleDeck();
        game.play();
        assertTrue(game.highestHandWinner().equals("Dealer wins with a hand worth " + dealer.dealerHandValueAbleToMakeAceHigh()) || game.highestHandWinner().equals("Player wins with a hand worth " + player1.playerHandValueAbleToMakeAceHigh()));
    }

    @Test
    public void checkGameCanBeDrawn(){
        deck.populateDeck();
        deck.shuffleDeck();
        player1.addCardToHand(card1);
        player1.addCardToHand(card1);
        dealer.addCardsToDealersHand(card3);
        dealer.addCardsToDealersHand(card3);
        assertEquals("It's a draw!", game.highestHandWinner());
    }

    @Test
    public void checkForBlackjackIsBlackjack(){
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);
        // asserting with getHandValue to make sure 11 as expected
        assertEquals(11, player1.getHandValue());
        // asserting with makeAceHigh to make sure Ace goes high as expected
        assertEquals(21, player1.playerHandValueAbleToMakeAceHigh());
        // asserting with makeAceHigh added to BlackJack test
        assertEquals("Blackjack!!", game.checkForBlackjack());
    }

    @Test
    public void checkForBlackjackIsNotBlackjack(){
        player1.addCardToHand(card1);
        player1.addCardToHand(card3);
        // asserting with getHandValue to make sure 11 as expected
        assertEquals(20, player1.getHandValue());
        // asserting with makeAceHigh to make sure doesn't goes high (no Ace in hand)
        assertEquals(20, player1.playerHandValueAbleToMakeAceHigh());
        // asserting with makeAceHigh added to BlackJack test (no Ace in hand)
        assertEquals("", game.checkForBlackjack());
    }

    @Test
    public void CanPlayerTwist(){
        deck.populateDeck();
        deck.shuffleDeck();
        game.play();
        game.playerDecidesIfShouldTwist();
        Integer playerTwistedNumCards = player1.numberOfCardsInHand();
        assertTrue(playerTwistedNumCards.equals(2) || playerTwistedNumCards.equals(3));
    }

    @Test
    public void testPlayerSticking(){
        deck.populateDeck();
        deck.shuffleDeck();
        game.play();
        game.playerDecidesIfShouldStick();
        assertEquals(2, player1.numberOfCardsInHand());
        Boolean playerSticking = game.playerDecidesIfShouldStick();
        assertTrue(playerSticking.equals(true) || playerSticking.equals(false));
    }

    @Test
    public void CanDealerTwist(){
        deck.populateDeck();
        deck.shuffleDeck();
        game.play();
        game.dealerDecidesIfShouldTwist();
        Integer dealerTwistedNumCards = dealer.numberOfCardsInDealersHand();
        assertTrue(dealerTwistedNumCards.equals(2) || dealerTwistedNumCards.equals(3));
    }

    @Test
    public void testDealerSticking(){
        deck.populateDeck();
        deck.shuffleDeck();
        game.play();
        game.dealerDecidesIfShouldStick();
        assertEquals(2, dealer.numberOfCardsInDealersHand());
        Boolean dealerSticking = game.dealerDecidesIfShouldStick();
        assertTrue(dealerSticking.equals(true) || dealerSticking.equals(false));
    }

    @Test
    public void testPlayerBust(){
        player1.addCardToHand(card1);
        player1.addCardToHand(card3);
        player1.addCardToHand(card4);
        assertEquals(true, game.checkIfPlayerBust());
    }

    @Test
    public void testPlayerNotBust(){
        player1.addCardToHand(card1);
        player1.addCardToHand(card3);
        assertEquals(false, game.checkIfPlayerBust());
    }

    @Test
    public void testDealerBust(){
        dealer.addCardsToDealersHand(card1);
        dealer.addCardsToDealersHand(card3);
        dealer.addCardsToDealersHand(card4);
        assertEquals(true, game.checkIfDealerBust());
    }

    @Test
    public void testDealerNotBust(){
        dealer.addCardsToDealersHand(card1);
        dealer.addCardsToDealersHand(card4);
        assertEquals(false, game.checkIfDealerBust());
    }
}
