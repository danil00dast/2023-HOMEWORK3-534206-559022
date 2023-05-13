package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	private final static String NOME = "fine";
	public final static String FINE = "Grazie di aver giocato!!";

	@Override
	public void esegui(Partita partita) {
		IO io=new IOConsole();
		partita.setFinita(true);
		io.mostraMessaggio(FINE);
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
