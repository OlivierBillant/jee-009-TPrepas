package model.dal;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bo.Ingredient;
import model.bo.Repas;

/**
 * Interface : définit les fonctionnalités qu'on cherche à avoir
 */
public interface RepasDAO {
	/*
	 * Je veux pouvoir ajouter un avis
	 */
	public void add(Repas repas) throws SQLException;
	
	public ArrayList<Repas> show() throws SQLException;
	
	public ArrayList<Ingredient> detail(int id) throws SQLException;
}
