package is.gestioneelaborati.entity;



public class ElaboratoInserito {
	private String nomeElaborato;
	private String insegnamento;
	private Docente docente;
	
	public ElaboratoInserito() {
		super();
		this.nomeElaborato=null;
		this.insegnamento=null;
		this.docente=null;
	}
	
	public ElaboratoInserito(String nomeElaborato, String insegnamento, Docente docente) {
		super();
		this.nomeElaborato=nomeElaborato;
		this.insegnamento = insegnamento;
		this.docente = docente;
	}
	
	public String getNomeElaborato() {
		return nomeElaborato;
	}
	
	public void setNomeElaborato(String nomeElaborato) {
		this.nomeElaborato=nomeElaborato;
	}
	
	
	public String getInsegnamento() {
		return insegnamento;
	}


	public void setInsegnamento(String insegnamento) {
		this.insegnamento = insegnamento;
	}


	public Docente getDocente() {
		return docente;
	}


	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	public boolean equals(ElaboratoInserito elaborato) {
		boolean uguali=false;
		if(this.nomeElaborato.equalsIgnoreCase(elaborato.getNomeElaborato()))
			uguali= true;
		return uguali;
    }
	
}



