package is.gestioneelaborati.entity;

public class ElaboratoAssegnato extends ElaboratoInserito {
	private Studente studente;
	
	public ElaboratoAssegnato() {
		super();
		this.studente=null;
	}
	
	public ElaboratoAssegnato(String nome, String insegnamento, Docente docente, Studente studente) {
		super(nome,insegnamento, docente);
		this.studente=studente;
	}
	
	public Studente getStudente() {
		return studente;
		
	}
	
	public void setStudente(Studente studente) {
		this.studente=studente;
	}
	
}
