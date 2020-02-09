package is.gestionelaborati;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import is.gestioneelaborati.database.DBManager;

public class InizializzaDB {

	public static void main(String[] args) {
try {
			
			Connection conn = DBManager.getConnection();
			
			String query;
			
			query = "CREATE TABLE ELABORATOINSERITO("
					+" NOMEELABORATO VARCHAR(30) NOT NULL ,"
					+" INSEGNAMENTO VARCHAR(40),"
					+" NOMEDOCENTE VARCHAR(30),"
					+" COGNOMEDOCENTE VARCHAR(30)"
					+");";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)) {
				
				stmt.executeUpdate();
			}
			
			
			query = "CREATE TABLE ELABORATOASSEGNATO("
					+" NOMEELABORATO VARCHAR(30) NOT NULL ,"
					+" INSEGNAMENTO VARCHAR(40),"
					+" NOMEDOCENTE VARCHAR(30),"
					+" COGNOMEDOCENTE VARCHAR(30),"
					+" MATRICOLA VARCHAR(30),"
					+" CFU INT"
					+");";
					
			
			
			try(PreparedStatement stmt = conn.prepareStatement(query)) {
				
				stmt.executeUpdate();
			}
			
			
			
			System.out.println("Inizializzazione DB completata.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
