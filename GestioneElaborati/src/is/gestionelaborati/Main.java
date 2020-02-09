package is.gestionelaborati;

import java.sql.SQLException;

import is.gestioneelaborati.control.GestioneElaborati;
import is.gestioneelaborati.entity.Docente;
import is.gestioneelaborati.entity.Domanda;
import is.gestioneelaborati.entity.ElaboratoInserito;
import is.gestioneelaborati.entity.Studente;

public class Main {

	public static void main(String[] args) {

		GestioneElaborati gestioneelaborati = null;
		
		try {
			
			gestioneelaborati = new GestioneElaborati();

			String nome_docente = "Flora";
			
			String cognome_docente = "Amato";
			
			Docente docente = new Docente(nome_docente,cognome_docente);
			
			String nome_elaborato = "Data Base NewSQL";
		
			String insegnamento = "BASI DI DATI";
			
			ElaboratoInserito elaborato1 = new ElaboratoInserito(nome_elaborato, insegnamento, docente);
		
		
			

			nome_docente = "Simon Pietro";
			
			cognome_docente = "Romano";
			
			docente = new Docente(nome_docente,cognome_docente);
			
			nome_elaborato = "Smart Contracts";
		
			insegnamento = "CALCOLATORI ELETTRONICI I";
			
			ElaboratoInserito elaborato2 = new ElaboratoInserito(nome_elaborato, insegnamento, docente);
			
			

			nome_docente = "Luca";
			
			cognome_docente = "Maresca";
			
			docente = new Docente(nome_docente,cognome_docente);
			
			nome_elaborato = "Processori RISC V";
		
			insegnamento = "ELETTRONICA GENERALE ";
			
			ElaboratoInserito elaborato3 = new ElaboratoInserito(nome_elaborato, insegnamento, docente);
			
			
			nome_docente = "NUNZIA ANTONIETTA";
			
			cognome_docente = "D'AURIA";
			
			docente = new Docente(nome_docente,cognome_docente);
			
			nome_elaborato = "Serie di Fourier";
		
			insegnamento = "METODI MATEMATICI PER L'INGEGNERIA";
			
			ElaboratoInserito elaborato4 = new ElaboratoInserito(nome_elaborato, insegnamento, docente);

		
		
		
			gestioneelaborati.aggiuntaElaboratoDocente(elaborato1);
			gestioneelaborati.aggiuntaElaboratoDocente(elaborato2);
			gestioneelaborati.aggiuntaElaboratoDocente(elaborato3);
			gestioneelaborati.aggiuntaElaboratoDocente(elaborato4);
		
			ElaboratoInserito[] preferenzeMie = new ElaboratoInserito[3];
			preferenzeMie[0] = elaborato2;
			preferenzeMie[1] = elaborato3;
			preferenzeMie[2] = elaborato4;
			
			Domanda domandaMia = new Domanda(preferenzeMie);
			
			
			
			Studente studenteIo = new Studente(120,"N46003747",domandaMia,null);
			
			if(gestioneelaborati.richiestaAssegnazioneElaborato(studenteIo, gestioneelaborati.lista_elaborati)){
				System.out.println("Assegnazione andata a buon fine");
			}
			else {
				System.out.println("Richiesta respinta");
			}
			
			
			System.out.println(studenteIo.getElaboratoStudente().getNomeElaborato());
			
		
			
			
			

		} catch (SQLException e) {

			System.out.println("Errore accesso DB");

			e.printStackTrace();
		
			System.exit(1);
		}
	
	
		
	}

}
