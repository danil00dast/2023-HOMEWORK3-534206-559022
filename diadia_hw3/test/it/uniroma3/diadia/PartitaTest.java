package it.uniroma3.diadia;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	private Stanza biblioteca;

	@Before
	public void setUp() {
		partita = new Partita();
		biblioteca = partita.getLabirinto().getStanzaVincente();
	}

	/**
	 * Test che si occupa di verificare se la partita � vinta se sono in biblioteca
	 **/
	@Test
	public void testVinta() {
		partita.getLabirinto().setStanzaCorrente(biblioteca);
		assertTrue(partita.vinta());
	}


	/**
	 * Test che si occupa di verificare se la partita � finita in caso di:
	 * - cfu=0
	 * - partita impostata finita
	 * - mi trovo in biblioteca
	 **/
	@Test
	public void testFinita() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());

		partita.setFinita();
		assertTrue(partita.isFinita());

		partita.getGiocatore().setCfu(1);
		partita.getLabirinto().setStanzaCorrente(biblioteca);
		assertTrue(partita.isFinita());
	}
}
