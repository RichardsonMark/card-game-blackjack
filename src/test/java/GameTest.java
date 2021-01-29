import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {

    Game game;
    Deck deck;
    Player player1;
    Player player2;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
        deck.populateDeck();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        game = new Game(deck, players);
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
        assertEquals(1, player1.numberOfCardsInHand());
        assertEquals(1, player2.numberOfCardsInHand());
        assertEquals(50, deck.getNumberOfCards());
    }

    @Test
    public void player1Wins(){
        player1.addCardToHand(new Card(SuitType.DIAMONDS, RankType.KING));
        player2.addCardToHand(new Card(SuitType.HEARTS, RankType.NINE));
        assertEquals(player1, game.checkWinner());
    }

    @Test
    public void drawReturnsNull(){
        player1.addCardToHand(new Card(SuitType.CLUBS, RankType.FIVE));
        player2.addCardToHand(new Card(SuitType.SPADES, RankType.FIVE));
        assertNull(game.checkWinner());
    }

}
