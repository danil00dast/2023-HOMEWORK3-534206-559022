package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

	private final static String NOME = "non valido";
	
	@Override
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		io.mostraMessaggio("Comando non valido!! Scrivi il comando 'aiuto' per vedere i comandi");
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
