package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;


public class ComandoFineTest {
	
	private ComandoFine comando;
	private Partita partita;
	
	@Before
	public void setUp() {
		this.comando = new ComandoFine();
		this.partita = new Partita();
	}
    @Test
	public void testGetNome() {
		assertEquals("fine", this.comando.getNome());
	}
	
	@Test
	public void testGetParametro() {
		assertNull(this.comando.getParametro());
	}
}
