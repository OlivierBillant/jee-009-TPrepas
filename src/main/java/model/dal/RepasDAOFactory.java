package model.dal;

/**
 * Classe qui va juste servir à faire le lien entre ma couche BLL et ma couche DAL
 */
public abstract class RepasDAOFactory {
	
	/**
	 * Cette méthode sert à éviter le : AvisDAO avisDAO = new AvisDAOJdbcImpl() dans la couche BLL
	 */
	public static RepasDAO getRepasDAO() {
		return new RepasDAOJdbcImpl();
	}
}
