package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.fbergeron.util.ImagePanel;

/**
 * @author Otávio da Cruz Mello
 */

public class UtilTest {

	/**
	 * Testa se a imagem foi carregada
	 */
	@Test
	public void testIsImageLoadedFalse() {
		ImagePanel ip = new ImagePanel();
		ip.setImage(null);

		assertEquals(false, ip.isImageLoaded());
	}
	
	/**
	 * Testa se o double buffered está desativado
	 */
	@Test
	public void testDoubleBufferedFalse() {
		ImagePanel ip = new ImagePanel();
		ip.setDoubleBuffered(false);

		assertEquals(false, ip.isDoubleBuffered());
	}
}
