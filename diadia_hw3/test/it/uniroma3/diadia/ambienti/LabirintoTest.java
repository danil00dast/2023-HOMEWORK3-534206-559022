package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

    private Labirinto labirinto;

    @Before
    public void setUp() {
        labirinto = Labirinto.newBuilder()
                .addStanzaIniziale("Stanza iniziale")
                .addStanzaVincente("Stanza vincente")
                .addStanza("Stanza 1")
                .addStanza("Stanza 2")
                .addStanza("Stanza 3")
                .addAttrezzo("Martello", 1)
                .addAttrezzo("Chiave", 1)
                .addAttrezzo("Libro", 1)
                .addAttrezzo("Pala", 1)
                .addAttrezzo("Cacciavite", 1)
                .addAttrezzo("Ombrello", 1)
                .addAttrezzo("Mappa", 1)
                .addAdiacenza("Stanza iniziale", "Stanza 1", "nord")
                .addAdiacenza("Stanza 1", "Stanza 2", "est")
                .addAdiacenza("Stanza 2", "Stanza 3", "sud")
                .addAdiacenza("Stanza 3", "Stanza vincente", "ovest")
                .getLabirinto();
    }

    @Test
    public void testGetStanzaIniziale() {
        Stanza stanzaIniziale = labirinto.getStanzaIniziale();
        assertNotNull(stanzaIniziale);
        assertEquals("Stanza iniziale", stanzaIniziale.getNome());
    }

    @Test
    public void testGetStanzaVincente() {
        Stanza stanzaVincente = labirinto.getStanzaVincente();
        assertNotNull(stanzaVincente);
        assertEquals("Stanza vincente", stanzaVincente.getNome());
    }

    @Test
    public void testGetStanzaCorrente() {
        Stanza stanzaIniziale = labirinto.getStanzaIniziale();
        labirinto.setStanzaCorrente(stanzaIniziale);
        assertEquals(stanzaIniziale, labirinto.getStanzaCorrente());
    }

}
