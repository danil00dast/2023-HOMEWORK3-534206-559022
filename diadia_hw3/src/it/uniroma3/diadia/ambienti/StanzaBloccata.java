package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

/* La stanza bloccata ha una delle direzioni inaccessibile, 
 * per sbloccare la direzione bisogna posare l'oggetto richiesto*/

public class StanzaBloccata extends Stanza{
	private IO io;
	private String direzioneBloccata;
	private String oggettoSbloccante;
	
	public StanzaBloccata(String nome,String direzioneBloccata,String oggetto) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.oggettoSbloccante = oggetto;
		io=new IOConsole();
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(oggettoSbloccante)) {
			io.mostraMessaggio("Chiuso!! Non puoi andare ad "+this.direzioneBloccata+ " senza prima aver posato: "+this.oggettoSbloccante);
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(oggettoSbloccante))
		return super.getDescrizione()+("\nL'uscita verso "+this.direzioneBloccata+" e' bloccata!!\nPer sbloccarla bisogna posare: "+this.oggettoSbloccante);
		else
		return super.getDescrizione();
		}
}
