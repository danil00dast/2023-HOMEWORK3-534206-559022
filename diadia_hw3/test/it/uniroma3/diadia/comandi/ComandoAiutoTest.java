package it.uniroma3.diadia.comandi;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import static org.junit.Assert.assertEquals;

public class ComandoAiutoTest {
	
	private ComandoAiuto comando;
	private Partita partita;
	
	@Before
	public void setUp() {
		comando = new ComandoAiuto();
		partita = new Partita();
	}
	
	@Test
	public void testEsegui() {
		comando.esegui(partita);
	}
	
	@Test
	public void testGetParametro() {
		assertEquals(null, comando.getParametro());
	}
	
	@Test
	public void testGetNome() {
		assertEquals("aiuto", comando.getNome());
	}
}
