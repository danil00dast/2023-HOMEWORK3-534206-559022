package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io ;


	public DiaDia(IO io) {
		this.io=io;
		this.partita = new Partita();
		}

	public DiaDia(Labirinto labirinto, IO io) {
		this.io = io;
		this.partita = new Partita(labirinto);
		}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

    private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

			io.mostraMessaggio("Hai esaurito i CFU, partita finita !!");

		return this.partita.isFinita();
	}

    public static void main(String[] argc) { 
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
		       
				.addStanzaIniziale("atrio").addAttrezzo("chiave", 1) 
		        .addStanzaVincente("Biblioteca")
		        .addStanzaBloccata("N10", "est", "chiave").addAttrezzo("lanterna", 3)
		        .addStanzaBuia("Laboratorio Campus",  "lanterna").addAttrezzo("spada", 4)
		        .addStanzaMagica("N11")
		        
		        .addAdiacenza("atrio","Biblioteca","nord") 
		        .addAdiacenza("atrio","N11","est") 
		        .addAdiacenza("atrio","N10","sud") 
		        .addAdiacenza("atrio","Laboratorio Campus","ovest") 
		        .addAdiacenza("N11","Laboratorio Campus","est") 
		        .addAdiacenza("N11","atrio","ovest") 
		        .addAdiacenza("N10","N11","est") 
		        .addAdiacenza("N10","atrio","nord") 
		        .addAdiacenza("N10","Laboratorio Campus","ovest") 
		        .addAdiacenza("Laboratorio Campus","atrio","est") 
		        .addAdiacenza("Laboratorio Campus","N11","ovest")
		        
		        .getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
	}
}