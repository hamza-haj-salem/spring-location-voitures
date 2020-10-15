package tn.enig.model;

public class Client {
	private int numPermis ;
	private String nom ;
	private String adress;
	public Client(int numPermis, String nom, String adress) {
		super();
		this.numPermis = numPermis;
		this.nom = nom;
		this.adress = adress;
	}
	public Client() {
		super();
	}
	public int getNumPermis() {
		return numPermis;
	}
	public void setNumPermis(int numPermis) {
		this.numPermis = numPermis;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	

}
