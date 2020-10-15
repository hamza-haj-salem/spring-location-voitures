package tn.enig.model;

public class Voiture {
	private int id ;
	private String marque;
	private String categorie;
	private Boolean disponobilite ; //nafs'ha fl base disponobolite
	
	
	
	public Voiture() {
		super();
	}



	public Voiture(int id, String marque, String categorie) {
		super();
		this.id = id;
		this.marque = marque;
		this.categorie = categorie;
		this.disponobilite = true;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}



	public Boolean getDisponobilite() {
		return disponobilite;
	}



	public void setDisponobilite(Boolean disponobilite) {
		this.disponobilite = disponobilite;
	}
	
	
	

}
