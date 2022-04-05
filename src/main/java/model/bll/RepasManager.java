package model.bll;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bo.Ingredient;
import model.bo.Repas;
import model.dal.RepasDAO;
import model.dal.RepasDAOFactory;

public class RepasManager {
	

	private RepasDAO repasDAO = RepasDAOFactory.getRepasDAO();
	

	
	public void add(Repas repas) throws BusinessException {
		// 1 - on valide les données
//		validation(repas);
		
		// 2 - si données OK, on envoie à la couche DAL
		try {
			this.repasDAO.add(repas);
		} catch (SQLException e) {
			// si jamais j'ai une erreur dans le DAO, je lance mon exception Business qui sera recupérée par mon servlet
			throw new BusinessException("erreur technique lors de l'insertion en base de donnée");
		}
	}

	/**
	 * Si jamais la validation ne passe pas : je lance une exception qui sera recupérée par mon servlet
	 * @throws SQLException 
	 */
//	private void validation(Repas repas) throws BusinessException {
//		// on valide que la note est comprise entre 0 et 5
//		if (repas.getNote() > 5 || avis.getNote() < 0) {
//			throw new BusinessException("la note doit être comprise entre 0 et 5");
//		}
//		// TODO : autres validations
//	}
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
