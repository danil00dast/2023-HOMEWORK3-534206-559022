package it.uniroma3.diadia.ambienti;

import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
    private String nome;
	private Map<String,Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;

	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>() ;
		this.attrezzi = new HashMap<>() ;
	}
	
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		if(direzione.equals("nord")||direzione.equals("sud")||direzione.equals("ovest")||direzione.equals("est"))
		this.stanzeAdiacenti.put(direzione,stanza);
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (attrezzo!=null&&this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI&&!this.attrezzi.containsKey(attrezzo.getNome())) {
			this.attrezzi.put(attrezzo.getNome(),attrezzo);
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Stanza Corrente: "+this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.stanzeAdiacenti.keySet())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");

		for(Attrezzo a : this.attrezzi.values()) {
			risultato.append(a.toString()+"");
		}

		return risultato.toString();
	}

    public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public boolean removeAttrezzo(Attrezzo attrezzo) {
		boolean trovato = false;
		Attrezzo attrezzoCercato = null;
		if(this.attrezzi.size()>=1) {
			attrezzoCercato=this.attrezzi.remove(attrezzo.getNome());
			if(attrezzoCercato!=null) {
				trovato=true;
			}
		}
		return trovato;
	}
	
	@Override
	public boolean equals(Object o) {
		Stanza that = (Stanza)o;
		return this.getNome().equals(that.getNome())&&this.getAttrezzi().equals(that.getAttrezzi());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode()+this.getAttrezzi().hashCode();
	}

	public List<String> getDirezioni() {
		return new ArrayList<String>(this.stanzeAdiacenti.keySet());
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		attrezzoCercato=this.attrezzi.get(nomeAttrezzo);
        return attrezzoCercato;
	}
	
	public static int getNumeroMassimoAttrezzi() {
		return NUMERO_MASSIMO_ATTREZZI;
	}
	
	public Map<String,Stanza> getMapStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}
	
	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}
	
	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.getNumeroAttrezzi();
	}
	
	public Stanza getStanzaAdiacente(String direzione) {
		return stanzeAdiacenti.get(direzione);
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescrizione() {
		return this.toString();
	}

	public List<Attrezzo> getAttrezzi() {
		return new ArrayList<Attrezzo>(this.attrezzi.values());
	}
}