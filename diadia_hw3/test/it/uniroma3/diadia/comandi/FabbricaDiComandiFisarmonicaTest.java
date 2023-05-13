package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandi fabbrica;

    @Before
    public void setUp() {
        this.fabbrica = new FabbricaDiComandiFisarmonica();
    }

    @Test
    public void testCostruisciComandoVai() {
        Comando comando = this.fabbrica.costruisciComando("vai nord");
        assertTrue(comando instanceof ComandoVai);
        assertEquals("nord", comando.getParametro());
    }

    @Test
    public void testCostruisciComandoPrendi() {
        Comando comando = this.fabbrica.costruisciComando("prendi martello");
        assertTrue(comando instanceof ComandoPrendi);
        assertEquals("martello", comando.getParametro());
    }

    @Test
    public void testCostruisciComandoNonValido() {
        Comando comando = this.fabbrica.costruisciComando("comandoNonValido");
        assertTrue(comando instanceof ComandoNonValido);
        assertNull(comando.getParametro());
    }

}
