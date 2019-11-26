package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.fbergeron.card.ClassicCard;
import com.fbergeron.card.Suit;
import com.fbergeron.card.Value;

/**
 * @author Otávio da Cruz Mello
 */


public class SolitaireTest {

	/**
	 * Testa o atributo que foi retornado pelo método isFaceDown quando a carta está
	 * virada para cima
	 */
	@Test
	public void testNotFaceDown() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		card.turnFaceUp();
		assertEquals(false, card.isFaceDown());
	}

}
