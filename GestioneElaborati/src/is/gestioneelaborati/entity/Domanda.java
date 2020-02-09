package is.gestioneelaborati.entity;

public class Domanda {
	private static final int NUMERO_PREFERENZE=3;
	private ElaboratoInserito[] preferenze = new ElaboratoInserito[NUMERO_PREFERENZE];
	
	public Domanda(ElaboratoInserito[] preferenze) {
		for(int i=0;i<NUMERO_PREFERENZE;i++)
			this.preferenze[i]=preferenze[i];
	}
	
	public ElaboratoInserito[] getPreferenze() {
		return preferenze;
	}

	public void setPreferenze(ElaboratoInserito[] preferenze) {
		for(int i=0;i<NUMERO_PREFERENZE;i++)
			this.preferenze[i]=preferenze[i];
	}
	
	
}
