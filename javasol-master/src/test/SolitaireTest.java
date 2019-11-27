package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.fbergeron.solitaire.GameInfo;
import com.fbergeron.solitaire.GameState;
import com.fbergeron.solitaire.LegalGameStates;

/**
 * @author Otávio da Cruz Mello
 */


public class SolitaireTest {

	/**
	 * Testa o retorno de tipo de Game Info
	 */
	@Test
	public void testGetType() {
		GameInfo gameInfo = new GameInfo("Tipo GameInfo", 10);
		gameInfo.setType("GameInfo");
		assertEquals("GameInfo", gameInfo.getType());
	}
	
	/**
	 * Testa o retorno de seed de Game Info
	 */
	@Test
	public void testGetSeed() {
		GameInfo gameInfo = new GameInfo("Tipo GameInfo", 10);
		gameInfo.setSeed(12);
		assertEquals(12, gameInfo.getSeed());
	}
	
	/**
	 * Testa se o retorno de Equals é verdadeiro, se já existe outro GameInfo
	 */
	@Test
	public void testEqualsTrue() {
		GameInfo gameInfo = new GameInfo("Tipo GameInfo", 10);
		GameInfo gameInfo2 = new GameInfo("Tipo GameInfo", 10);
		assertEquals(true, gameInfo.equals(gameInfo2));
	}
	
	/**
	 * Testa o retorno de Equals é falso, se não existe outro GameInfo
	 */
	@Test
	public void testEqualsFalse() {
		GameInfo gameInfo = new GameInfo("Tipo GameInfo", 10);
		GameInfo gameInfo2 = new GameInfo("Tipo GameInfo2", 12);
		assertEquals(false, gameInfo.equals(gameInfo2));
	}

	/**
	 * Testa o retorno do hash code de GameInfo
	 */
	@Test
	public void testHashCode() {
		GameInfo gameInfo = new GameInfo("Tipo GameInfo", 10);
		assertEquals("Tipo GameInfo|10".hashCode(), gameInfo.hashCode());
	}
	
	/**
	 * Testa se é possível retornar e setar os game states legais
	 */
	@Test
	public void testGetGameState() {
		ArrayList<GameState> gameState = new ArrayList<GameState>();
		gameState.add(new GameState(null, null, null, null, null));
		gameState.add(new GameState(null, null, null, null, null));
		LegalGameStates lgStates = new LegalGameStates();
		lgStates.setGameStates(gameState);
		
		assertEquals(gameState, lgStates.getGameStates());
	}
	
	/**
	 * Testa se é possível retornar e setar o GsIdx
	 */
	@Test
	public void testGetGsIdx() {
		LegalGameStates lgStates = new LegalGameStates();
		lgStates.setGsIdx(10);
		
		assertEquals(10, lgStates.getGsIdx());
	}

}
