package tn.enig.model;

public class Contrat {
	
	private int id ;
	private Client client;
	private Voiture voiture;
	private String dateDebut ;
	private String dateFin;
	
	public Contrat() {
		super();
	}

	public Contrat(int id, Client client, Voiture voiture, String dateDebut, String dateFin) {
		super();
		this.id = id;
		this.client = client;
		this.voiture = voiture;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", client=" + client + ", voiture=" + voiture + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}
	
	
	
	
	

}
