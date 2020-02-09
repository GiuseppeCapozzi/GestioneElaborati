package is.gestioneelaborati.database;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import is.gestioneelaborati.entity.Docente;
import is.gestioneelaborati.entity.ElaboratoInserito;




public class ElaboratoInseritoDAO {
	
	public static ElaboratoInserito createElaboratoInserito(String nome, String insegnamento, Docente docente) throws SQLException {
		
		ElaboratoInserito elaboratoInserito = new ElaboratoInserito(nome, insegnamento, docente);
		
		create(elaboratoInserito);
		
		return elaboratoInserito;
	}
	
	
	public static void create(ElaboratoInserito elaboratoInserito) throws SQLException {
		
		Connection conn = DBManager.getConnection();
		
		String query = "INSERT INTO ELABORATOINSERITO VALUES(?,?,?,?);";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, elaboratoInserito.getNomeElaborato());
			stmt.setString(2, elaboratoInserito.getInsegnamento());
			stmt.setString(3, elaboratoInserito.getDocente().getNome());
			stmt.setString(4, elaboratoInserito.getDocente().getCognome());
			
			stmt.executeUpdate();
		}
	}
		
		
		
	public static ElaboratoInserito read(String nomeElaborato) throws SQLException {
		
		ElaboratoInserito elaboratoInserito = null;
		
		Connection conn = DBManager.getConnection();
		
		String query = "SELECT NOMEELABORATO,INSEGNAMENTO,NOMEDOCENTE,COGNOMEDOCENTE FROM ELABORATOINSERITO WHERE NOMEELABORATO=?;";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, nomeElaborato);
			
			try(ResultSet result = stmt.executeQuery()) {
				
				if(result.next()) {
					
					String nomeEl = result.getString(1);
					String insegnamento = result.getString(2);
					String nomeDocente = result.getString(3);
					String cognomeDocente = result.getString(4);
					
					Docente docente= new Docente(nomeDocente, cognomeDocente);
				    elaboratoInserito  = new ElaboratoInserito(nomeEl, insegnamento, docente);
						
				}
					
			}
					
		}
		return elaboratoInserito;
	}
		
		
		

	

	
	public static ArrayList<ElaboratoInserito> readAll() throws SQLException {
		
		ArrayList<ElaboratoInserito> listaElaborati = new ArrayList<ElaboratoInserito>();
		
		Connection conn = DBManager.getConnection();
		
		String query = "SELECT NOMEELABORATO,INSEGNAMENTO,NOMEDOCENTE,COGNOMEDOCENTE FROM ELABORATOINSERITO;";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
						
			try(ResultSet result = stmt.executeQuery()) {
				
				while(result.next()) {
					
					String nomeElaborato = result.getString(1);
					String insegnamento = result.getString(2);
					String nomeDocente = result.getString(3);
					String cognomeDocente = result.getString(4);
					
					ElaboratoInserito elaboratoInserito = null;
					Docente docente=new Docente(nomeDocente,cognomeDocente);
					
					elaboratoInserito = new ElaboratoInserito(nomeElaborato, insegnamento,docente);
					
					
					
					listaElaborati.add(elaboratoInserito);
				}
		
			}
		}
		return listaElaborati;
	}
	
	
	public static void update(ElaboratoInserito elaboratoInserito) throws SQLException {
		
		Connection conn = DBManager.getConnection();
		
		String nomeElaborato = elaboratoInserito.getNomeElaborato();
		
		
		String query = "UPDATE ELABORATOINSERITO SET NOMEELABORATO=?, INSEGNAMENTO=?, NOMEDOCENTE=?, COGNOMEDOCENTE=? WHERE NOMEELABORATO=?";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, nomeElaborato);
			stmt.setString(2, elaboratoInserito.getInsegnamento());
			stmt.setString(3, elaboratoInserito.getDocente().getNome());
			stmt.setString(4, elaboratoInserito.getDocente().getCognome());
			
			stmt.setString(5, nomeElaborato);
			
			stmt.executeUpdate();
		}
		
	}
		
	
	
	
	public static void delete(ElaboratoInserito elaboratoInserito) throws SQLException {
		
		Connection conn = DBManager.getConnection();
		
		String nomeElaborato = elaboratoInserito.getNomeElaborato();
		
		String query = "DELETE FROM ELABORATOINSERITO WHERE NOMEELABORATO=?;";
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, nomeElaborato);
			
			stmt.executeUpdate();
		}
		
		
		
	}
	
}



