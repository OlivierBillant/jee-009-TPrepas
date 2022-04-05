package model.bo;

public class Ingredient {
	private int id;
	private String Libelle;

	public Ingredient(String libelle) {
		super();
		Libelle = libelle;
	}
	
	

	public Ingredient() {
		super();
	}



	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	@Override
	public String toString() {
		return  Libelle;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	

}
