package is.gestioneelaborati.entity;

import java.util.ArrayList;

public class Docente {
	private String nome;
	private String cognome;
	private ArrayList<ElaboratoAssegnato> lista_elaboratiAssegnati;
	
	public Docente(String nome, String cognome) {
		super();
		this.nome=nome;
		this.cognome=cognome;
		lista_elaboratiAssegnati = new ArrayList<ElaboratoAssegnato>();
	}
	
	public Docente(String nome, String cognome, ArrayList<ElaboratoAssegnato> lista_elaboratiAssegnati) {
		super();
		this.nome=nome;
		this.cognome=cognome;
		this.lista_elaboratiAssegnati=lista_elaboratiAssegnati;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
		
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome=cognome;
	}

	public ArrayList<ElaboratoAssegnato> getLista_elaboratiAssegnati(){
		return lista_elaboratiAssegnati;
	}
	
	public void setLista_elaboratiAssegnati(ArrayList<ElaboratoAssegnato> lista_elaboratiAssegnati) {
		this.lista_elaboratiAssegnati=lista_elaboratiAssegnati;
	}

}
