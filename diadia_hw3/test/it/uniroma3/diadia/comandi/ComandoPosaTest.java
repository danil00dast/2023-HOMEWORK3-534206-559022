package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {private ComandoPosa comandoPosa;
private Partita partita;
private Attrezzo attrezzoValido;
private Attrezzo attrezzoNonValido;

@Before
public void setUp() {
    this.comandoPosa = new ComandoPosa();
    this.partita = new Partita();
    this.attrezzoValido = new Attrezzo("AttrezzoValido", 1);
    this.attrezzoNonValido = new Attrezzo("AttrezzoNonValido", 1);
}

@Test
public void testSetParametro() {
    String nomeAttrezzo = "AttrezzoTest";
    comandoPosa.setParametro(nomeAttrezzo);
    assertEquals(nomeAttrezzo, comandoPosa.getParametro());
}

@Test
public void testGetNome() {
    assertEquals("posa", comandoPosa.getNome());
}

@Test
public void testGetParametro() {
    String nomeAttrezzo = "AttrezzoTest";
    comandoPosa.setParametro(nomeAttrezzo);
    assertEquals(nomeAttrezzo, comandoPosa.getParametro());
}
}