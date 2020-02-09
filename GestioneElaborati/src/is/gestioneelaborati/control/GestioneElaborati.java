package is.gestioneelaborati.control;


import java.sql.SQLException;
import java.util.ArrayList;

import is.gestioneelaborati.database.ElaboratoAssegnatoDAO;
import is.gestioneelaborati.database.ElaboratoInseritoDAO;
import is.gestioneelaborati.entity.ElaboratoAssegnato;
import is.gestioneelaborati.entity.ElaboratoInserito;
import is.gestioneelaborati.entity.Studente;



public class GestioneElaborati {
	
	private static final int CREDITI_SUFFICIENTI=110;
	private static final int NUMERO_PREFERENZE=3;
	
	public ArrayList<ElaboratoInserito> lista_elaborati;
	
	public GestioneElaborati() throws SQLException {
		
		lista_elaborati = ElaboratoInseritoDAO.readAll();
	}
	
	public void aggiuntaElaboratoDocente(ElaboratoInserito elaborato) throws SQLException {
		
		if(elaborato != null) {
		lista_elaborati.add(elaborato);
		
		ElaboratoInseritoDAO.create(elaborato);
		}
		
	}
	
	public boolean richiestaAssegnazioneElaborato(Studente studente, ArrayList<ElaboratoInserito> lista_elaborati) throws SQLException{
		boolean esito = false;
		if((studente != null) && (lista_elaborati != null)) {
			if(studente.getCfu()<CREDITI_SUFFICIENTI) {
				esito=false;
			}
			else
			{
				for(int i=0;(i<NUMERO_PREFERENZE)&&(!esito);i++) {
					if((studente.getDomanda().getPreferenze()[i].getDocente().getLista_elaboratiAssegnati().size()<10)) {
							esito=true;
							ElaboratoAssegnato elaboratoAssegnato = new ElaboratoAssegnato(studente.getDomanda().getPreferenze()[i].getNomeElaborato(), studente.getDomanda().getPreferenze()[i].getInsegnamento(), studente.getDomanda().getPreferenze()[i].getDocente(), studente);
							studente.getDomanda().getPreferenze()[i].getDocente().getLista_elaboratiAssegnati().add(elaboratoAssegnato);
							studente.setElaboratoStudente(elaboratoAssegnato);
							ElaboratoAssegnatoDAO.create(elaboratoAssegnato);
					}
					if(!esito) {
							ElaboratoInserito[] lista= new ElaboratoInserito[lista_elaborati.size()];
							lista=lista_elaborati.toArray(lista);
							for(int j=0;(j<lista_elaborati.size())&&(!esito);j++) {
								if(!(lista[j].equals(studente.getDomanda().getPreferenze()[0])) && !(lista[j].equals(studente.getDomanda().getPreferenze()[1])) && !(lista[j].equals(studente.getDomanda().getPreferenze()[2]))) {
									esito=true;
									ElaboratoAssegnato elaboratoAssegnato = new ElaboratoAssegnato(lista[j].getNomeElaborato(), lista[j].getInsegnamento(), lista[j].getDocente(), studente);
									lista[j].getDocente().getLista_elaboratiAssegnati().add(elaboratoAssegnato);
									studente.setElaboratoStudente(elaboratoAssegnato);
									ElaboratoAssegnatoDAO.create(elaboratoAssegnato);
								}
							}
				     }
				} 
			}
		
		}
		return esito;
	}
}
