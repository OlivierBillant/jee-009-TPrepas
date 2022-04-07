package model.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Repas {
	private int Identifiant;
	private LocalDate date;
	private LocalTime heure;
	private ArrayList<Ingredient> composition = new ArrayList<>();
	
	public Repas(LocalDate date, LocalTime heure, ArrayList<Ingredient> composition) {
		super();
		this.date = date;
		this.heure = heure;
		this.composition = composition;
	}
	
	public Repas(LocalDate date, LocalTime heure) {
		super();
		this.date = date;
		this.heure = heure;
	}
	

	public Repas(LocalDate date) {
		super();
		this.date = date;
	}

	public Repas() {
		super();
	}

	public int getIdentifiant() {
		return Identifiant;
	}

	public void setIdentifiant(int identifiant) {
		Identifiant = identifiant;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public ArrayList<Ingredient> getComposition() {
		return composition;
	}

	public void setComposition(ArrayList<Ingredient> composition) {
		this.composition = composition;
		
		
	}

	
	
	@Override
	public String toString() {
		return "Repas \nIdentifiant : " + Identifiant + "\nDate : " + date + "\nHeure :" + heure + "\nComposition : "
				+ composition + "";
	}
	
	
}
