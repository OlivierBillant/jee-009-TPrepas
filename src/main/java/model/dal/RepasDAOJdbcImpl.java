package model.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import model.bo.Repas;

/**
 * Implémentation des fonctionnalités de mon interface AvisDAO avec JDBC (en base de donnée)
 */
public class RepasDAOJdbcImpl implements RepasDAO {
	
	// on définit notre requête SQL d'insertion avec des ? qu'on remplira par la suite
	private final static String INSERT = "insert into Repas(date, heure) values(?,?);";

	public void add(Repas repas) throws SQLException{
		Connection cnx = ConnectionProvider.getConnection();
		
		PreparedStatement pStmt = cnx.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
		
		pStmt.setDate(1, Date.valueOf(repas.getDate()) ); 
		pStmt.setTime(2, Time.valueOf(repas.getHeure()) ); 
		
		pStmt.executeUpdate();
		
		ResultSet rs = pStmt.getGeneratedKeys();
		if (rs.next()) {
			repas.setIdentifiant(rs.getInt(1));
		}
	}

}
