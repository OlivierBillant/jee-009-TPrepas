package model.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.bo.Ingredient;
import model.bo.Repas;
import model.dal.RepasDAO;
import model.dal.RepasDAOFactory;

public class RepasManager {
	

	private RepasDAO repasDAO = RepasDAOFactory.getRepasDAO();
	

	
	public void add(Repas repas) throws BusinessException {
		validation(repas);
		
		try {
			this.repasDAO.add(repas);
		} catch (SQLException e) {
			throw new BusinessException("erreur technique lors de l'insertion en base de donnée");
		}
	}

	/**
	 * Si jamais la validation ne passe pas : je lance une exception qui sera recupérée par mon servlet
	 * @throws SQLException 
	 */
	private void validation(Repas repas) throws BusinessException {
		if (repas.getDate().isAfter(LocalDate.now())) {
			throw new BusinessException("la date doit être supérieure à la date du jour");
		}
		if(repas.getComposition().size()<2) {
			throw new BusinessException("le repas doit etre composé d'au moins 2 ingrédients");
		}
		
	}
	
	
	public ArrayList<Repas> show() throws BusinessException, SQLException {
		// 1 - on valide les données
//		validation(repas);
		
		// 2 - si données OK, on envoie à la couche DAL
		
			ArrayList<Repas> listeRepas = this.repasDAO.show();
		
		return listeRepas;
	}
	
	public ArrayList<Ingredient> detail(int id) throws BusinessException, SQLException {
		// 1 - on valide les données
//		validation(repas);
		
		// 2 - si données OK, on envoie à la couche DAL
		
			ArrayList<Ingredient> listeIngredient = this.repasDAO.detail(id);
		
		return listeIngredient;
	}
}
