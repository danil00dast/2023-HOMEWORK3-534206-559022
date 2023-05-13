package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private boolean finita;
	private Giocatore giocatore;
	
    public Partita(){
		this.labirinto = new LabirintoBuilder().getLabirinto();
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
		this.giocatore= new Giocatore();
		this.finita = false;
	}
	
	public Partita(Labirinto labirinto){
		this.labirinto = labirinto;
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
		this.giocatore= new Giocatore();
		this.finita = false;
		
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public void setFinita(boolean finita) {
		this.finita = finita;
	}	

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean vinta() {
		return stanzaCorrente==labirinto.getStanzaVincente();
	}

    public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCfu()>0) {
			return true;
		}
		else {
			return false;
		}
	}

    public Labirinto getLabirinto() {
		return labirinto;
	}

    public Giocatore getGiocatore() {
		return giocatore;
	}

    public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
}
