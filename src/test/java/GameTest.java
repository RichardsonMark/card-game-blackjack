import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {

    Game game;
    Deck deck;
    Player player1;
    Player player2;
    Dealer dealer;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
        dealer = new Dealer();
        deck.populateDeck();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        game = new Game(deck, players, dealer);
    }

    @Test
    public void canAddPlayer(){
        assertEquals(2, game.getNumPlayers());
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
        assertEquals("Player wins!", game.highestHandWinner());
    }

//    @Test
//    public void checkWhoWinsHighestHandRealGame(){
//        deck.populateDeck();
//        deck.shuffleDeck();
//        game.play();
//    }


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
