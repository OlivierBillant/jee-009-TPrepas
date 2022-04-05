package model.bll;

import java.sql.SQLException;

import model.bo.Repas;
import model.dal.RepasDAO;
import model.dal.RepasDAOFactory;

/**
 * Couche BLL / couche Services
 * C'est là qu'on va effectuer les traitements metiers et la validation des données
 * Cette couche a une réference vers la couche DAL
 */
public class RepasManager {
	
	/**
	 * AvisDAO : reférence vers notre couche DAL
	 */
	// Plutôt que de définir la relation entre AvisManager et AvisDAO directement : AvisDAO avisDAO = new AvisDAOJdbcImpl();
	// On va passer par une Factory pour avoir une meilleur indépendance entre les composants (bonne pratique)	
	private RepasDAO repasDAO = RepasDAOFactory.getRepasDAO();
	

	/**
	 * add() : est appelé par le servlet
	 * => va envoyer les données à la couche DAL après validation
	 * @throws BusinessException 
	 */
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
	 */
//	private void validation(Repas repas) throws BusinessException {
//		// on valide que la note est comprise entre 0 et 5
//		if (repas.getNote() > 5 || avis.getNote() < 0) {
//			throw new BusinessException("la note doit être comprise entre 0 et 5");
//		}
//		// TODO : autres validations
//	}
	
}
