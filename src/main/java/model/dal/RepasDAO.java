package model.dal;

import java.sql.SQLException;

import model.bo.Repas;

/**
 * Interface : définit les fonctionnalités qu'on cherche à avoir
 */
public interface RepasDAO {
	/*
	 * Je veux pouvoir ajouter un avis
	 */
	public void add(Repas repas) throws SQLException;
}
