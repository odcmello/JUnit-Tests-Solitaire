package test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import com.fbergeron.card.Card;
import com.fbergeron.card.ClassicCard;
import com.fbergeron.card.Stack;
import com.fbergeron.card.Suit;
import com.fbergeron.card.Value;

/**
 * @author Otávio da Cruz Mello
 */

public class CardTest {

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

	/**
	 * Testa o atributo que foi retornado pelo método isFaceDown quando a carta está
	 * virada para baixo
	 */
	@Test
	public void testFaceDown() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		card.turnFaceDown();
		assertEquals(true, card.isFaceDown());
	}

	/**
	 * Testa se valores setados para posição em X e Y estão corretos
	 */
	@Test
	public void testGetLocation() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		card.setLocation(new Point(5, 9));
		assertEquals(card.getLocation(), new Point(5, 9));
		assertEquals(card.getLocation().getX(), 5, 0);
		assertEquals(card.getLocation().getY(), 9, 0);
	}

	/**
	 * Testa se valores setados para o tamanho de um card estão corretos
	 */
	@Test
	public void testGetSize() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		card.setSize(new Dimension(150, 160));
		assertEquals(new Dimension(150, 160), card.getSize());
		assertEquals(160, card.getSize().getHeight(), 0);
		assertEquals(150, card.getSize().getWidth(), 0);
	}

	/**
	 * Testa se quando um card estiver virado para baixo e sofrer flip ele foi
	 * virado para cima
	 */
	@Test
	public void testFlipFaceDown() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		card.turnFaceDown();
		card.flip();
		assertEquals(false, card.isFaceDown());
	}

	/**
	 * Testa se quando um card estiver virado para cima e sofrer flip ele foi virado
	 * para baixo
	 */
	@Test
	public void testFlipFaceUp() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		card.turnFaceUp();
		card.flip();
		assertEquals(true, card.isFaceDown());
	}

	/**
	 * Testa se um card é legal no jogo
	 */
	@Test
	public void testIfLegalTrue() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		card.setLegal(true);
		assertEquals(true, card.isLegal());
	}

	/**
	 * Testa se o card não é legal no jogo
	 */
	@Test
	public void testIfLegalFalse() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		card.setLegal(false);
		assertEquals(false, card.isLegal());
	}

	/**
	 * Testa se o ponto está contido no retângulo
	 */
	@Test
	public void testRectContainsTrue() {
		Point p = new Point(5, 9);
		Rectangle r = new Rectangle(5, 9, 10, 10);
		assertEquals(true, r.contains(p));
	}

	/**
	 * Testa se o ponto não está contido no retângulo
	 */
	@Test
	public void testRectContainsFalse() {
		Point p = new Point(10, 20);
		Rectangle r = new Rectangle(5, 9, 10, 10);
		assertEquals(false, r.contains(p));
	}

	/**
	 * Testa se a cor da carta retornada é preta
	 */
	@Test
	public void testGetColorBlack() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.CLUB);
		assertEquals(Color.black, card.getColor());
	}

	/**
	 * Testa se a cor da carta retornada é vermelha
	 */
	@Test
	public void testGetColorRed() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.HEART);
		assertEquals(Color.red, card.getColor());
	}

	/**
	 * Testa se o valor retornado da carta é correto
	 */
	@Test
	public void testValue() {

		int i = 0;
		ArrayList<ClassicCard> card = new ArrayList<ClassicCard>();
		card.add(new ClassicCard(Value.V_1, Suit.HEART));
		card.add(new ClassicCard(Value.V_2, Suit.HEART));
		card.add(new ClassicCard(Value.V_3, Suit.HEART));
		card.add(new ClassicCard(Value.V_4, Suit.HEART));
		card.add(new ClassicCard(Value.V_5, Suit.HEART));
		card.add(new ClassicCard(Value.V_6, Suit.HEART));
		card.add(new ClassicCard(Value.V_7, Suit.HEART));
		card.add(new ClassicCard(Value.V_8, Suit.HEART));
		card.add(new ClassicCard(Value.V_9, Suit.HEART));
		card.add(new ClassicCard(Value.V_10, Suit.HEART));
		card.add(new ClassicCard(Value.V_11, Suit.HEART));
		card.add(new ClassicCard(Value.V_12, Suit.HEART));
		card.add(new ClassicCard(Value.V_13, Suit.HEART));

		for (ClassicCard c : card) {
			assertEquals(Value.values[i], c.getValue());
			i++;
		}

	}

	/**
	 * Testa se o naipe retornado pela carta é correto
	 */
	@Test
	public void testSuit() {

		int i = 0;
		ArrayList<ClassicCard> card = new ArrayList<ClassicCard>();
		card.add(new ClassicCard(Value.V_1, Suit.HEART));
		card.add(new ClassicCard(Value.V_1, Suit.SPADE));
		card.add(new ClassicCard(Value.V_1, Suit.DIAMOND));
		card.add(new ClassicCard(Value.V_1, Suit.CLUB));

		for (ClassicCard c : card) {
			assertEquals(Suit.suits[i], c.getSuit());
			i++;
		}

	}

	/**
	 * Testa se um card é igual ao outro
	 */
	@Test
	public void testEqualCard() {

		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_1, Suit.HEART);

		a.turnFaceDown();
		b.turnFaceDown();

		assertEquals(true, a.equals(b));

	}

	/**
	 * Testa se um stack está vazio
	 */
	@Test
	public void testIfStackEmptyTrue() {

		Stack s = new Stack();
		assertEquals(true, s.isEmpty());

	}

	/**
	 * Testa se um stack não está vazio
	 */
	@Test
	public void testIfStackEmptyFalse() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		s.push(a);
		assertEquals(false, s.isEmpty());

	}

	/**
	 * Testa as cartas que são retornados pelo stack de cartas
	 */
	@Test
	public void testStackGetCards() {

		Stack s = new Stack();
		Vector cards = new Vector();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		s.push(a);
		cards.addElement(a);

		assertEquals(cards, s.getCards());

	}

	/**
	 * Testa as cartas que estão viradas para cima no stack e verifica se a primeira
	 * (ultima colocada) está
	 */
	@Test
	public void testGetFirstCardFaceUp() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		ClassicCard c = new ClassicCard(Value.V_3, Suit.HEART);
		c.turnFaceUp();
		s.push(a);
		s.push(b);
		s.push(c);

		assertEquals(2, s.firstFaceUp());

	}

	/**
	 * Testa as cartas que estão viradas para cima no stack e verifica se a primeira
	 * (ultima colocada) não está
	 */
	@Test
	public void testGetFirstCardFaceDown() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		ClassicCard c = new ClassicCard(Value.V_3, Suit.HEART);
		s.push(a);
		s.push(b);
		s.push(c);

		assertEquals(-1, s.firstFaceUp());

	}

	/**
	 * Testa se a carta que está no topo do stack é retornada corretamente
	 */
	@Test
	public void testCardTopStack() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		ClassicCard c = new ClassicCard(Value.V_3, Suit.HEART);
		s.push(a);
		s.push(b);
		s.push(c);

		assertEquals(c, s.top());

	}

	/**
	 * Testa se a carta que está no topo do stack do vazio retorna vazio
	 */
	@Test
	public void testCardTopStackEmpty() {

		Stack s = new Stack();
		assertEquals(null, s.top());

	}

	/**
	 * Testa o retorno de uma carta em uma posição dentro do stack
	 */
	@Test
	public void testCardElementAtStack() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		s.push(a);
		s.push(b);

		assertEquals(b, s.elementAt(1));

	}

	/**
	 * Testa se quando a carta do topo do stack é removida, a carta é retornada
	 */
	@Test
	public void testPopCard() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		s.push(a);
		s.push(b);

		assertEquals(b, s.pop());

	}

	/**
	 * Testa se quando X cartas são removidas do stack, um novo stack com essas X
	 * cartas é retornado
	 */
	@Test
	public void testPopStackNumbers() {

		Stack s = new Stack();
		Stack st = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		ClassicCard c = new ClassicCard(Value.V_3, Suit.HEART);
		ClassicCard d = new ClassicCard(Value.V_4, Suit.HEART);
		s.push(a);
		s.push(b);
		s.push(c);
		s.push(d);

		st.push(d);
		st.push(c);

		assertEquals(st.getCards(), s.pop(2).getCards());

	}

	/**
	 * Testa se quando X cartas são removidas do stack até chegar em uma determinada
	 * carta, essas cartas retiradas vão ser retornadas como stack
	 */
	@Test
	public void testPopStackCard() {

		Stack s = new Stack();
		Stack st = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		ClassicCard c = new ClassicCard(Value.V_3, Suit.HEART);
		ClassicCard d = new ClassicCard(Value.V_4, Suit.HEART);
		s.push(a);
		s.push(b);
		s.push(c);
		s.push(d);

		st.push(d);
		st.push(c);

		assertEquals(st.getCards(), s.pop(c).getCards());

	}

	/**
	 * Testa o retorno de quantas cartas existem no stack
	 */
	@Test
	public void testGetStackSize() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		ClassicCard c = new ClassicCard(Value.V_3, Suit.HEART);
		ClassicCard d = new ClassicCard(Value.V_4, Suit.HEART);
		s.push(a);
		s.push(b);
		s.push(c);
		s.push(d);

		assertEquals(4, s.cardCount());

	}
	
	/**
	 * Testa se stack contém carta baseado na carta
	 */
	@Test
	public void testStackContainsCardTrue() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		s.push(a);

		assertEquals(true, s.contains(a));

	}
	
	/**
	 * Testa se stack não contém carta baseado na carta
	 */
	@Test
	public void testStackContainsCardFalse() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);

		assertEquals(false, s.contains(a));

	}
	
	/**
	 * Testa se o stack contém carta baseado em ponto
	 */
	@Test
	public void testStackContainsCardPointTrue() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		a.setLocation(10,10);
		s.push(a);

		assertEquals(true, s.contains(new Point(10,10)));

	}
	
	/**
	 * Testa se o stack não contém carta baseado em ponto
	 */
	@Test
	public void testStackContainsCardPointFalse() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		a.setLocation(10,10);

		assertEquals(false, s.contains(new Point(100,100)));

	}
	
	/**
	 * Testa o retorno de uma carta que foi clicada a partir do ponto, deve receber a carta de retorno
	 */
	@Test
	public void testGetClickedCard() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		a.setLocation(new Point(10,10));
		s.push(a);

		assertEquals(a, s.getClickedCard(new Point(10,10)));

	}
	
	/**
	 * Testa se quando a pilha for revertida, a carta do topo será a primeira que
	 * foi inserida (vai empilhando, cada push vira a primeira)
	 */
	@Test
	public void testReverse() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		ClassicCard c = new ClassicCard(Value.V_3, Suit.HEART);
		ClassicCard d = new ClassicCard(Value.V_4, Suit.HEART);
		s.push(a);
		s.push(b);
		s.push(c);
		s.push(d);
		
		s.reverse();

		assertEquals(a, s.pop());

	}

	/**
	 * Testa se a localização é retornada corretamente
	 */
	@Test
	public void testLocation() {

		Stack s = new Stack();
		ClassicCard a = new ClassicCard(Value.V_1, Suit.HEART);
		ClassicCard b = new ClassicCard(Value.V_2, Suit.HEART);
		s.push(a);
		s.push(b);
		s.setLocation(15, 10);

		assertEquals(15, s.getLocation().getX(),0);
		assertEquals(10, s.getLocation().getY(),0);

	}

	/**
	 * Testa se o retorno de direção é correto
	 */
	@Test
	public void testGetSpreadingDirection() {

		Stack s = new Stack();
		s.setSpreadingDirection(10);


		assertEquals(10, s.getSpreadingDirection(),0);

	}
	
	/**
	 * Testa se o retorno do delta é correto
	 */
	@Test
	public void testGetSpreadingDelta() {

		Stack s = new Stack();
		s.setSpreadingDelta(10);

		assertEquals(10, s.getSpreadingDelta(),0);

	}
}
