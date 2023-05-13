package it.uniroma3.diadia.ambienti;

public class Labirinto{
	
	private Stanza stanzaIniziale;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

    public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
     public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
}
