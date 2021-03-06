package model.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import model.bo.Ingredient;
import model.bo.Repas;

/**
 * Implémentation des fonctionnalités de mon interface AvisDAO avec JDBC (en base de donnée)
 */
public class RepasDAOJdbcImpl implements RepasDAO {
	
	// on définit notre requête SQL d'insertion avec des ? qu'on remplira par la suite
	private final static String INSERT_REPAS = "insert into Repas(date, heure) values(?,?);";
	private final static String INSERT_INGREDIENT = "insert into Ingredient(nom, id_repas) values(?,?);";

	public void add(Repas repas) throws SQLException{
		Connection cnx = ConnectionProvider.getConnection();
		
		PreparedStatement pStmt = cnx.prepareStatement(INSERT_REPAS,Statement.RETURN_GENERATED_KEYS);
		
		pStmt.setDate(1, Date.valueOf(repas.getDate()) ); 
		pStmt.setTime(2, Time.valueOf(repas.getHeure()) ); 
		
		pStmt.executeUpdate();
		
		ResultSet rs = pStmt.getGeneratedKeys();
		if (rs.next()) {
			repas.setIdentifiant(rs.getInt(1));
		}
		
		PreparedStatement pStmt2 = cnx.prepareStatement(INSERT_INGREDIENT,Statement.RETURN_GENERATED_KEYS);
		
		for (Ingredient ingredient : repas.getComposition()) {
			String ingredient_temp = ingredient.toString();
			pStmt2.setString(1, ingredient_temp); 
			pStmt2.setInt(2, repas.getIdentifiant()); 
			
			pStmt2.executeUpdate();
			
			ResultSet rs2 = pStmt2.getGeneratedKeys();
			if (rs2.next()) {
				ingredient.setId(rs2.getInt(1));
			}
		}
	}

	public ArrayList<Repas> show() throws SQLException {
		ArrayList<Repas> listeRepas = new ArrayList<Repas>();
		Connection cnx = ConnectionProvider.getConnection();
		String sql = "SELECT * from Repas;";
		try {
			Statement state = cnx.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				Repas r = new Repas();
				r.setIdentifiant(rs.getInt("id"));
				r.setDate(rs.getDate("date").toLocalDate());
				r.setHeure(rs.getTime("heure").toLocalTime());
				listeRepas.add(r);
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listeRepas;
	}
	
	public ArrayList<Ingredient> detail(int id) throws SQLException {
		ArrayList<Ingredient> listeIngredient = new ArrayList<Ingredient>();
		Connection cnx = ConnectionProvider.getConnection();
		String sqlPrepared = "SELECT * FROM Ingredient WHERE id_repas = ?";
		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				Ingredient ing = new Ingredient();
				ing.setLibelle(rs.getString("nom"));
				listeIngredient.add(ing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeIngredient;
	}
	
	}

