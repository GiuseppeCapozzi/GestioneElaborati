package is.gestioneelaborati.entity;



public class Studente {
	private int cfu;
	private String matricola;
	private Domanda domanda;
	private ElaboratoAssegnato elaboratoStudente;
	
	public Studente() {
		super();
		cfu=0;
		matricola=null;
		domanda=null;
		elaboratoStudente=null;
	}
	
	public Studente(int cfu, String matricola, Domanda domanda, ElaboratoAssegnato elaboratoStudente) {
		super();
		this.cfu=cfu;
		this.matricola=matricola;
		this.domanda=domanda;
		this.elaboratoStudente=elaboratoStudente;
	}
	
	public Studente(int cfu, String matricola) {
		super();
		this.cfu=cfu;
		this.matricola=matricola;
		this.domanda=null;
		this.elaboratoStudente=null;
		
	}
	
	public int getCfu() {
		return cfu;
	}


	public void setCfu(int cfu) {
		this.cfu = cfu;
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public Domanda getDomanda() {
		return domanda;
	}


	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}

	public ElaboratoAssegnato getElaboratoStudente() {
		return elaboratoStudente;
	}

	public void setElaboratoStudente(ElaboratoAssegnato elaboratoStudente) {
		this.elaboratoStudente = elaboratoStudente;
	}
	
	
	

}
