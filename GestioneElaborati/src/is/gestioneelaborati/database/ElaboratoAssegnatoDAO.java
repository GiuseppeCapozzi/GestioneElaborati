package is.gestioneelaborati.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import is.gestioneelaborati.entity.Docente;
import is.gestioneelaborati.entity.ElaboratoAssegnato;
import is.gestioneelaborati.entity.Studente;

public class ElaboratoAssegnatoDAO {
	
	public static ElaboratoAssegnato createElaboratoAssegnato(String nome,String insegnamento, Docente docente, Studente studente  ) throws SQLException{
		
		ElaboratoAssegnato elaboratoAssegnato = new ElaboratoAssegnato(nome,insegnamento,docente,studente);
		
		create(elaboratoAssegnato);
		
		return elaboratoAssegnato;
	}
	
	public static void create(ElaboratoAssegnato elaboratoAssegnato) throws SQLException {
		
		Connection conn = DBManager.getConnection();
		
		String query = "INSERT INTO ELABORATOASSEGNATO VALUES(?,?,?,?,?,?);";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1,elaboratoAssegnato.getNomeElaborato());
			stmt.setString(2,elaboratoAssegnato.getInsegnamento());
			stmt.setString(3,elaboratoAssegnato.getDocente().getNome());
			stmt.setString(4,elaboratoAssegnato.getDocente().getCognome());
			stmt.setString(5,elaboratoAssegnato.getStudente().getMatricola());
			stmt.setInt(6,elaboratoAssegnato.getStudente().getCfu());
			
			stmt.executeUpdate();
		}
	}
		
		
		
	public static ElaboratoAssegnato read(String nomeElaborato) throws SQLException {
		
		ElaboratoAssegnato elaboratoAssegnato = null;
		
		Connection conn = DBManager.getConnection();
		
		String query = "SELECT NOMEELABORATO,INSEGNAMENTO,NOMEDOCENTE,COGNOMEDOCENTE,MATRICOLA,CFU FROM ELABORATOASSEGNATO WHERE NOMEELABORATO=?;";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, nomeElaborato);
			
			try(ResultSet result = stmt.executeQuery()) {
				
				if(result.next()) {
					
					String nomeEl = result.getString(1);
					String insegnamento = result.getString(2);
					String nomeDocente = result.getString(3);
					String cognomeDocente = result.getString(4);
					String matricola = result.getString(5);
					int cfu = result.getInt(6);
					
					Docente docente= new Docente(nomeDocente, cognomeDocente);
					Studente studente= new Studente(cfu,matricola);
				    elaboratoAssegnato  = new ElaboratoAssegnato(nomeEl, insegnamento, docente, studente);
						
				}
					
			}
					
		}
		return elaboratoAssegnato;
	}
		
		
		

	

	
	public static ArrayList<ElaboratoAssegnato> readAll() throws SQLException {
		
		ArrayList<ElaboratoAssegnato> listaElaborati = new ArrayList<ElaboratoAssegnato>();
		
		Connection conn = DBManager.getConnection();
		
		String query = "SELECT NOMEELABORATO,INSEGNAMENTO,NOMEDOCENTE,COGNOMEDOCENTE,MATRICOLA,CFU FROM ELABORATOASSEGNATO;";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
						
			try(ResultSet result = stmt.executeQuery()) {
				
				while(result.next()) {
					
					String nomeElaborato = result.getString(1);
					String insegnamento = result.getString(2);
					String nomeDocente = result.getString(3);
					String cognomeDocente = result.getString(4);
					String matricola = result.getString(5);
					int cfu = result.getInt(6);
					
					ElaboratoAssegnato elaboratoAssegnato = null;
					Docente docente=new Docente(nomeDocente,cognomeDocente);
					Studente studente= new Studente(cfu,matricola);
					
					elaboratoAssegnato = new ElaboratoAssegnato(nomeElaborato, insegnamento,docente,studente);
					
					
					
					listaElaborati.add(elaboratoAssegnato);
				}
		
			}
		}
		return listaElaborati;
	}
	
	
	public static void update(ElaboratoAssegnato elaboratoAssegnato) throws SQLException {
		
		Connection conn = DBManager.getConnection();
		
		String nomeElaborato = elaboratoAssegnato.getNomeElaborato();
		
		
		String query = "UPDATE ELABORATOASSEGNATO SET NOMEELABORATO=?, INSEGNAMENTO=?, NOMEDOCENTE=?, COGNOMEDOCENTE=?, MATRICOLA=?, CFU=? WHERE NOMEELABORATO=?";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, nomeElaborato);
			stmt.setString(2, elaboratoAssegnato.getInsegnamento());
			stmt.setString(3, elaboratoAssegnato.getDocente().getNome());
			stmt.setString(4, elaboratoAssegnato.getDocente().getCognome());
			stmt.setString(5, elaboratoAssegnato.getStudente().getMatricola());
			stmt.setInt(6, elaboratoAssegnato.getStudente().getCfu());
			
			stmt.setString(7, nomeElaborato);
			
			stmt.executeUpdate();
		}
		
	}
		
	
	
	
	public static void delete(ElaboratoAssegnato elaboratoAssegnato) throws SQLException {
		
		Connection conn = DBManager.getConnection();
		
		String nomeElaborato = elaboratoAssegnato.getNomeElaborato();
		
		String query = "DELETE FROM ELABORATOASSEGNATO WHERE NOMEELABORATO=?;";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, nomeElaborato);
			
			stmt.executeUpdate();
		}
		
		
		
	}
	
}

	
	


